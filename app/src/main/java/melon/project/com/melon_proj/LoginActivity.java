package melon.project.com.melon_proj;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import melon.project.com.melon_proj.customview.ClearEditText;

public class LoginActivity extends AppCompatActivity {


    private LinearLayout btnLinear;
    private LinearLayout signupLinear;
    private LinearLayout loginstage;
    private ClearEditText editEmail;
    private ClearEditText editPassword;
    private ClearEditText editPassCheck;
    private ClearEditText editName;

    private boolean emailCheck = false;
    private boolean passwordCheck = false;
    private boolean passCheck = false;
    private boolean nameCheck = false;
    private Button btnSignin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseSetting();
        initView();
    }

    // ============================================================ 로그인 처리
    public void signin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    // ============================================================ 회원가입 처리
    public void signup(View view) {

    }

    // ============================================================ View를 컨트롤 하는 메서드
    public void showSignup(View view) {
        btnLinear.setVisibility(View.GONE);
        signupLinear.setVisibility(View.VISIBLE);
    }

    public void cancel(View view) {
        btnLinear.setVisibility(View.VISIBLE);
        signupLinear.setVisibility(View.GONE);
        editPassCheck.setText("");
        editName.setText("");
    }

    // ============================================================ findViewbyId
    private void initView() {
        btnLinear = findViewById(R.id.btnLinear);
        signupLinear = findViewById(R.id.signupLinear);
        loginstage = findViewById(R.id.loginstage);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPassCheck = findViewById(R.id.editPassCheck);
        editName = findViewById(R.id.editName);
        btnSignin = findViewById(R.id.btn_signin);
        btnSignup = findViewById(R.id.btn_signup);

        loginstage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });

        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString();
                if (string.length() > 25) {
                    string = string.substring(0, string.length() - 1);
                    editEmail.setText(string);
                    editEmail.setSelection(string.length());
                }
                emailCheck = isValidEmail(string);
                enableSignupButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString();
                if (string.length() > 16) {
                    string = string.substring(0, string.length() - 1);
                    editPassword.setText(string);
                    editPassword.setSelection(string.length());
                }
                passwordCheck = isValidPassword(string);
                enableSignupButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editPassCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString();
                if (string.length() > 16) {
                    string = string.substring(0, string.length() - 1);
                    editPassCheck.setText(string);
                    editPassCheck.setSelection(string.length());
                }
                passCheck = isValidPassword(string) && (editPassword.getText().toString().equals(string));
                enableSignupButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString();
                if (string.length() > 10) {
                    string = string.substring(0, string.length() - 1);
                    editName.setText(string);
                    editName.setSelection(string.length());
                }
                nameCheck = isValidName(string);
                enableSignupButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // ============================================================ Email 체크하기
    private boolean isValidEmail(String email) {
        String regex = "^[a-z0-9A-Z_-]+(.[a-z0-9A-Z_-])*@([a-z0-9A-Z.])+.([a-zA-Z]){2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    // ============================================================ Password 체크하기
    private boolean isValidPassword(String password) {
        String regex = "^[A-Za-z0-9]{8,16}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    // ============================================================ 이름 체크하기
    public boolean isValidName(String str){
        String regex = "^[가-힣A-Za-z0-9]{2,12}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();

    }

    // ============================================================ 반응형 앱만들기
    private void enableSignupButton() {
        if(emailCheck && passwordCheck) {
            btnSignin.setEnabled(true);
        }else {
            btnSignin.setEnabled(false);
        }
        if (emailCheck && passCheck && passwordCheck && nameCheck) {
            btnSignup.setEnabled(true);
        } else {
            btnSignup.setEnabled(false);
        }
    }

    // ============================================================ Firebase Setting
    private void firebaseSetting() {
    }
}
