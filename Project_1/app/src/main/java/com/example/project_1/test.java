package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class test extends AppCompatActivity {

    private RequestQueue requestQueue;
    private Button predict;
    private EditText sex, age, current_smoker, cigs_per_day, BP_meds, Pre_stroke, Pre_hype, diabetes, tot_chol, sys_BP, dia_BP, BMI, heartrate, glucose;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mAuth = FirebaseAuth.getInstance();

        sex = (EditText)findViewById(R.id.sex);
        age = (EditText)findViewById(R.id.age);
        current_smoker = (EditText)findViewById(R.id.current_smoker);
        cigs_per_day = (EditText)findViewById(R.id.cigs_per_day);
        BP_meds = (EditText)findViewById(R.id.BP_meds);
        Pre_stroke = (EditText)findViewById(R.id.Pre_stroke);
        Pre_hype = (EditText)findViewById(R.id.Pre_hype);
        diabetes = (EditText)findViewById(R.id.diabetes);
        tot_chol = (EditText)findViewById(R.id.tot_chol);
        sys_BP = (EditText)findViewById(R.id.sys_BP);
        dia_BP = (EditText)findViewById(R.id.dia_BP);
        BMI = (EditText)findViewById(R.id.BMI);
        heartrate = (EditText)findViewById(R.id.heartrate);
        glucose = (EditText)findViewById(R.id.glucose);

        predict = (Button) findViewById(R.id.predict);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test.this, result.class));
                }
        });
    }
    /*private void Submit(String data)
    {
        final String savedata= data;
        String URL="https://ussouthcentral.services.azureml.net/workspaces/ab8e1cecc5f94c0bba414b2d9ea77445/services/199028c672844aacaa2faa5144e86f85/execute?api-version=2.0&details=true";

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    Toast.makeText(getApplicationContext(),objres.toString(),Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        };
        requestQueue.add(stringRequest);*/

}