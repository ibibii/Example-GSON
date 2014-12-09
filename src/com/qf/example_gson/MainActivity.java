package com.qf.example_gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.example_gson.entity.FinalURL;
import com.qf.example_gson.entity.Others;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/**
 * GSON只能用String,找不到用JSONObject的方法.
 * 下面的例子,出错.String不符合要求.
 * @author uaige
 *
 * 2014年12月9日下午4:42:31
 */
public class MainActivity extends Activity implements Listener<JSONObject>{
	private TextView tx;
	private RequestQueue mQuqu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tx = (TextView) findViewById(R.id.tx);
		mQuqu=Volley.newRequestQueue(this);
		mQuqu.add(new JsonObjectRequest(Method.GET, "http://news-at.zhihu.com/api/3/themes", null, this, null));
	}
	@Override
	public void onResponse(JSONObject json) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		List<Others> list = new ArrayList<Others>();
		list = gson.fromJson(FinalURL.URL, (Type) new Others());
		for(int j = 0;j<list.size();j++){
			Log.i("MainActivity.class",String.valueOf(j).toString());
		}
	}
}
