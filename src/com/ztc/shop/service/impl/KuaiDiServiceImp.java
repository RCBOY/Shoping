package com.ztc.shop.service.impl;

import com.ztc.shop.model.KuaiDiBack;
import com.ztc.shop.model.Trace;
import com.ztc.shop.service.KuaiDiService;
import com.ztc.shop.unit.KuaiDiSecurity;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description：快递查询的业务逻辑类
 * Created by ZTCJoe on 2016/10/24.
 */
@SuppressWarnings("unchecked")
@Service("KuaiDiService")
public class KuaiDiServiceImp implements KuaiDiService {
    //电商ID
    private String EBusinessID="1267562";
    //电商加密私钥，快递鸟提供，注意保管，不要泄漏
    private String AppKey="108146e5-9dde-4d37-b65e-e8e2daa62bbd";
    //请求url
    private String ReqURL="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    /**
     * Json方式 查询订单物流轨迹
     * @throws Exception
     */
    @Override
    public KuaiDiBack getOrderTracesByJson(String expCode, String expNo) throws Exception {
        String requestData= "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", KuaiDiSecurity.urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign=KuaiDiSecurity.encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", KuaiDiSecurity.urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result=sendPost(ReqURL, params);

        List<Trace> traces=new LinkedList<>();
        KuaiDiBack kuaiDiBack=new KuaiDiBack();
        org.json.JSONObject jsonObject= new org.json.JSONObject(result.toString());
        kuaiDiBack.setEBusinessID(jsonObject.getString("EBusinessID"));
        kuaiDiBack.setShipperCode(jsonObject.getString("ShipperCode"));
        kuaiDiBack.setSuccess(jsonObject.getString("Success"));
        kuaiDiBack.setLogisticCode(expNo);
        org.json.JSONArray jsonArray = jsonObject.getJSONArray("Traces");
            if (!jsonObject.getString("Traces").equals("[]")) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    Trace trace = new Trace();
                    org.json.JSONObject temp = new org.json.JSONObject(jsonArray.getString(i));
                    trace.setAcceptTime(temp.getString("AcceptTime"));
                    trace.setAcceptStation(temp.getString("AcceptStation"));
                    traces.add(trace);
                }
                kuaiDiBack.setTraces(traces);
                if (jsonObject.getString("State").equals("2")){
                    kuaiDiBack.setState("在途中");
                }
                if (jsonObject.getString("State").equals("3")){
                    kuaiDiBack.setState("已签收");
                }
                if (jsonObject.getString("State").equals("4")){
                    kuaiDiBack.setState("问题件");
                }
                kuaiDiBack.setReason("no");
            } else {
                kuaiDiBack.setReason(jsonObject.getString("Reason"));
                kuaiDiBack.setTraces(null);
            }
        return kuaiDiBack;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求的参数集合
     * @return 远程资源的响应结果
     */
    protected String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(param.length()>0){
                        param.append("&");
                    }
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    //System.out.println(entry.getKey()+":"+entry.getValue());
                }
                //System.out.println("param:"+param.toString());
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
    }

