package com.usage.whattoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.kakaolink.AppActionBuilder;
import com.kakao.kakaolink.AppActionInfoBuilder;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.kakaolink.internal.LinkObject;
import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.message.template.TextTemplate;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.util.KakaoParameterException;
import com.kakao.util.helper.log.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 선언부 */
        final RandomPick randomPick = new RandomPick();
        final TextView viewtext = (TextView)findViewById(R.id.viewText);

        findViewById(R.id.createButton).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String randomtext = randomPick.getRandTestString();
                        Toast.makeText(getApplicationContext(), randomtext, Toast.LENGTH_LONG).show();
                        viewtext.setText(randomtext);
                    }
                }
        );

        findViewById(R.id.kakaolink).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            String msg = viewtext.getText().toString();
                            KakaoLink kakaoLink = KakaoLink.getKakaoLink(MainActivity.this);
                            KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

                            KakaoTalkLinkMessageBuilder contents = kakaoTalkLinkMessageBuilder
                                    .addText("[" + getString(R.string.app_name) + "]\n"
                                            + "오늘 메뉴는 " + msg + "(으)로 정해졌습니다.\n땅 땅 땅")
                                    .addAppButton("앱으로 이동",
                                            new AppActionBuilder()
                                                    .addActionInfo(AppActionInfoBuilder
                                                            .createAndroidActionInfoBuilder()
                                                            .build())
                                                    .addActionInfo(AppActionInfoBuilder.createiOSActionInfoBuilder()
                                                            .build())
                                                    .build());
                            kakaoLink.sendMessage(contents, MainActivity.this);
                            Toast.makeText(getApplicationContext(), "전송완료", Toast.LENGTH_LONG).show();
                        } catch (KakaoParameterException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}
