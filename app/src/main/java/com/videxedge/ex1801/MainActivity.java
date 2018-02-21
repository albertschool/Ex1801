package com.videxedge.ex1801;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eTphone, eTmsg;
    String smsNum, smsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTphone=(EditText)findViewById(R.id.eTphone);
        eTmsg=(EditText)findViewById(R.id.eTmsg);
    }

    public void msgappsend(View view) {
        smsNum=eTphone.getText().toString();
        smsText=eTmsg.getText().toString();

        Uri smsRealNumber= Uri.parse("smsto:"+smsNum);
        Intent smsIntent=new Intent(Intent.ACTION_SENDTO,smsRealNumber);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("sms_body",smsText);
        smsIntent.setData(smsRealNumber);
        startActivity(smsIntent);
    }

    public void msgsend(View view) {
        smsNum=eTphone.getText().toString();
        smsText=eTmsg.getText().toString();

        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(smsNum, null, smsText, null, null);
    }
}
