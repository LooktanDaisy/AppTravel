package com.application.youngdeveloper.apptravel.libs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.fg.mdp.psi.goldspot.R;
import com.fg.mdp.psi.goldspot.authetication.Logon;
import com.fg.mdp.psi.goldspot.dataModel.Symbol;
import com.fg.mdp.psi.goldspot.dataModel.msgMK;
import com.fg.mdp.psi.goldspot.dataModel.msgVA;
import com.fg.mdp.psi.goldspot.listener.OnKeyPinListener;
import com.fg.mdp.psi.goldspot.msg.MsgProperties;
import com.mdp.core.system.systemInfo;
import com.mdp.core.util.NumberUtil;

import java.lang.String;
import java.util.regex.Pattern;


/**
 * Created by Suphadate_Noy on 8/6/2015.
 */
public class GenaralFunction {

    static {
        Logon.Instance().PinListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (CompoundButton V : CheckTable) {
                    if (V != null) {
                        V.setChecked(isChecked);
                    }
                }
            }
        });

        Logon.Instance().TextPinListener(new OnKeyPinListener() {
            @Override
            public void TextChange(View Typing, String Text) {
                for (EditText V : PassTable) {
                    if (V != null && V != Typing) {
                        V.setText(Text);
                    }
                }
            }
        });
    }

    public static final String black = "#817f7b";
    public static final String white = "#ffffff";
    public static final String green = "#139529";
    public static final String red = "#b12424";
    public static final String gray = "#555456";
    public static final String COLOR_TXT_BUTTON = "#33322f";
    public static final String Gold_Spot_offer1 = "#b12424";
    public static final String Gold_Spot_offer2 = "#cd5555";
    public static final String Gold_Spot_offer3 = "#dd3b3b";
    public static final String Gold_Spot_bid1 = "#139529";
    public static final String Gold_Spot_bid2 = "#459e54";
    public static final String Gold_Spot_bid3 = "#48af59";
    private static final String G999 = "99.9";
    private static final String G965 = "96.5";
    private static final String G999p = "99.9%";
    private static final String G965p = "96.5%";
    private static final String Green = "green";

    public static ArrayList<CompoundButton> CheckTable = new ArrayList<>();
    public static ArrayList<EditText> PassTable = new ArrayList<>();

    public static String summationLong(String agr1, String agr2) {
        Long VOLUME, PRICE;
        String sum = null;
        if (agr1 != null && agr2 != null) {

            VOLUME = NumberUtil.parseLong(agr1.replace(",", ""));
            PRICE = NumberUtil.parseLong(agr2.replace(",", ""));
            sum = GenaralFunction.comma(VOLUME * PRICE);
            return sum;
        }
        return sum;
    }

    public static String summation99Long(String agr1, String agr2) {
        Long VOLUME, PRICE;
        String sum = null;
        if (agr1 != null && agr2 != null) {
            VOLUME = NumberUtil.parseLong(agr1.replace(",", ""));
            PRICE = NumberUtil.parseLong(agr2.replace(",", ""));
            sum = GenaralFunction.comma(VOLUME * ((PRICE * 656) / 10));
            return sum;
        }
        return sum;
    }

    public static Double summation(String agr1, String agr2) {
        Double VOLUME, PRICE, sum = 0.0;
        if (agr1 != null && agr2 != null) {

            VOLUME = NumberUtil.parseDouble(agr1.replace(",", ""));
            PRICE = NumberUtil.parseDouble(agr2.replace(",", ""));
            sum = VOLUME * PRICE;
            return sum;
        }
        return sum;
    }

    public static String AddDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.########");
        return df.format(value);
    }

    public static String decimalDown(String value) {
//        int Position;
//        if (value != null && (Position = value.indexOf(".")) > -1) {
//            value = value.substring(0, Position);
//        }

        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(NumberUtil.parseDouble(value));
    }

    public static String decimalDown(double value) {
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(value);
    }

    public static Double summation99(String Vol, String PriceBaht) {
        Double VOLUME, PRICE, sum = 0.0;
        if (Vol != null && PriceBaht != null) {
            VOLUME = NumberUtil.parseDouble(Vol.replace(",", ""));
            PRICE = NumberUtil.parseDouble(PriceBaht.replace(",", ""));
            sum = Double.valueOf(Math.round(VOLUME * ((PRICE * 656) / 10)));
            return (double) Math.round(sum);
        }
        return sum;
    }

    public static Double summation99DonwDecimal(String Vol, String PriceBaht) {
        Double VOLUME, PRICE, sum = 0.0;
        if (Vol != null && PriceBaht != null) {
            VOLUME = NumberUtil.parseDouble(Vol.replace(",", ""));
            PRICE = NumberUtil.parseDouble(PriceBaht.replace(",", ""));
            sum = VOLUME * ((PRICE * 656) / 10);
            Log.d("PlaceorderMSG", String.valueOf(sum));

            return NumberUtil.parseDouble(decimalDown(sum));
        }
        return NumberUtil.parseDouble(decimalDown(sum));
    }

    public static double summation99placeOrder(String Vol, String PriceBaht) {
        double VOLUME, PRICE, sum = 0.00000000;
        if (Vol != null && PriceBaht != null) {
            VOLUME = NumberUtil.parseDouble(Vol.replace(",", ""));
            PRICE = NumberUtil.parseDouble(PriceBaht.replace(",", ""));
            sum = (VOLUME * ((PRICE * 656) / 10));
            sum = NumberUtil.parseDouble(AddDecimal(sum));


            return sum;
        }
        return sum;
    }

    public static String convertExponential(Double agr1) {
        String sum = null;
        if (agr1 != null && !Double.isNaN(agr1)) {
            sum = BigDecimal.valueOf(agr1).toPlainString();
        }
        return sum;
    }

    public static String getCanSell999VolStr() {
        if (msgMK.Instance().CanViewPrice()) {
            if (msgVA.Instance().Account_SellCredit != null) {
                double Credit = NumberUtil.parseDouble(GenaralFunction.decimalDown(msgVA.Instance().Account_SellCredit));
                if (!Double.isNaN(Credit) && Credit > 0) {
                    double Summing = Symbol.SummationG999KG(Credit, MsgProperties.G999KGbid);
                    if (Summing > 1) {
                        return GenaralFunction.comma(GenaralFunction.decimalDown(Summing));
                    }
                }
            }
        }
        return "0";
    }

    public static String getCanBuy999VolStr() {
        if (msgMK.Instance().CanViewPrice()) {
            if (msgVA.Instance().Account_BuyCredit != null) {
                double Credit = NumberUtil.parseDouble(GenaralFunction.decimalDown(msgVA.Instance().Account_BuyCredit));
                if (!Double.isNaN(Credit) && Credit > 0) {
                    double Summing = Symbol.SummationG999KG(Credit, MsgProperties.G999KGoffer);
                    if (Summing > 1) {
                        return GenaralFunction.comma(GenaralFunction.decimalDown(Summing));
                    }
                }
            }
        }
        return "0";
    }

    public static String getCanBuy965VolStr() {
        if (msgMK.Instance().CanViewPrice()) {
            if (msgVA.Instance().Account_BuyCredit != null) {
                double Credit = NumberUtil.parseDouble(GenaralFunction.decimalDown(msgVA.Instance().Account_BuyCredit));
                if (!Double.isNaN(Credit) && Credit > 0) {
                    double Summing = Symbol.Summation965B(Credit, MsgProperties.G965Boffer);
                    if (Summing > 1) {
                        return GenaralFunction.comma(GenaralFunction.RoundNumbers5_0(Summing));
                    }
                }
            }
        }
        return "0";
    }

    public static String getCanSell965VolStr() {
        if (msgMK.Instance().CanViewPrice()) {
            if (msgVA.Instance().Account_SellCredit != null) {
                double Credit = NumberUtil.parseDouble(GenaralFunction.decimalDown(msgVA.Instance().Account_SellCredit));
                if (!Double.isNaN(Credit) && Credit > 0) {
                    double Summing = Symbol.Summation965B(Credit, MsgProperties.G965Bbid);
                    if (Summing > 1) {
                        return GenaralFunction.comma(GenaralFunction.RoundNumbers5_0(Summing));
                    }
                }
            }
        }
        return "0";
    }

    public static String comma(double agr1) {
        if (agr1 != 0) {

            DecimalFormat formatter = new DecimalFormat("#,###");
            return formatter.format(agr1);
        }
        return "0";
    }

    public static String comma(String agr1) {
        agr1 = agr1.replace(",", "");
        double agr2 = NumberUtil.parseLong(agr1);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(agr2);

    }

    public static String deleteComma(String agr1) {
        if (agr1 != null) {
            return agr1.replace(",", "");
        }
        return agr1;
    }

    public static String deleteCommaNotDecimail(String agr1) {
        String number = null;
        if (agr1 != null && agr1.length() > 0) {
            agr1 = agr1.replace(",", "");
            double agr = Double.valueOf(agr1).longValue();
            DecimalFormat decimalFormatter = new DecimalFormat("0");
            number = decimalFormatter.format(agr);
            return number;
        }
        return number;
    }

    public static String setDecimal2ToString(double agr1) {
        if (agr1 != 0) {
            DecimalFormat decimalFormatter = new DecimalFormat("#,###.00");
            return decimalFormatter.format(agr1);
        }
        return "0";

    }

    public static String setnoDecimalToString(double agr1) {
        if (agr1 != 0) {
            agr1 = Double.valueOf(agr1).longValue();
            DecimalFormat decimalFormatter = new DecimalFormat("0");
            return decimalFormatter.format(agr1);
        }
        return "0";
    }

    public static void clickChangeColor(Button btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.white);
                btnClick.setTextColor(Color.parseColor(black));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(white));
                btnClick.setBackgroundResource(R.color.colorPrimary);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.white);
                btnClick.setTextColor(Color.parseColor(black));

            }
        }
    }

    public static void setTextColorGreen(TextView textView) {
        if (!textView.equals(null)) {
            textView.setTextColor(Color.parseColor(green));
            textView.setTextSize(20);
        }
    }

    public static void setTextColorRed(TextView textView) {
        if (!textView.equals(null)) {
            textView.setTextColor(Color.parseColor(red));

        }
    }

    public static String getColorView(String colorView) {
        if (colorView != null) {
            if (colorView.equalsIgnoreCase(Green)) {
                return green;
            } else {
                return red;
            }
        }
        return "";
    }

    public static void clickChangeColorRed(Button btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer3);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));

            }
        }
    }

    public static void clickChangeColorRed(TextView btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer3);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_offer1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));

            }
        }
    }

    public static void clickChangeColorGreen(Button btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid3);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));

            }
        }
    }

    public static void clickChangeColorGreen(TextView btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid3);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.Gold_Spot_bid1);
                btnClick.setTextColor(Color.parseColor(COLOR_TXT_BUTTON));

            }
        }
    }

    public static void clickChangeColor2(Button btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.gray);
                btnClick.setTextColor(Color.parseColor(white));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(gray));
                btnClick.setBackgroundResource(R.color.white2);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.gray);
                btnClick.setTextColor(Color.parseColor(white));

            }
        }
    }


    public static void clickChangeColor3(View Click, MotionEvent event, TextView txt) {
        if (Click != null && event != null && txt != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Click.setBackgroundResource(R.color.gray);
                txt.setTextColor(Color.parseColor(white));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                txt.setTextColor(Color.parseColor(gray));
                Click.setBackgroundResource(R.color.white2);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                Click.setBackgroundResource(R.color.gray);
                txt.setTextColor(Color.parseColor(white));

            }
        }
    }

    public static void clickChangeColor4(Button btnClick, MotionEvent event) {
        if (btnClick != null && event != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                btnClick.setBackgroundResource(R.color.gray);
                btnClick.setTextColor(Color.parseColor(white));
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                btnClick.setTextColor(Color.parseColor(white));
                btnClick.setBackgroundResource(R.color.white2);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                btnClick.setBackgroundResource(R.color.gray);
                btnClick.setTextColor(Color.parseColor(white));

            }
        }
    }

    public static Object getOrderside(HashMap map) {
        if (map != null) {
            String strOrder = null;
            HashMap<Object, HashMap> hashmapCurrent = new HashMap<>();
            Object keyOrder = map.get(MsgProperties.Order_No);
            hashmapCurrent.put(keyOrder, map);

            map = hashmapCurrent.get(keyOrder);
            if (map.get(MsgProperties.Order_Side).equals(MsgProperties.Buy) || map.get(MsgProperties.Order_Side).equals(MsgProperties.B)) {
                strOrder = MsgProperties.B;
            } else if (map.get(MsgProperties.Order_Side).equals(MsgProperties.Sell) || map.get(MsgProperties.Order_Side).equals(MsgProperties.S)) {
                strOrder = MsgProperties.S;
            }

            return strOrder;
        }
        return "";
    }

    /**
     * created by Natthawut_Teb on 1/11/2016.
     */
    public static String getTypeGold(String Stock_Symbol) {
        if (Stock_Symbol != null) {
            if (Stock_Symbol.equals(MsgProperties.G965B)) {
                return G965p;
            } else if (Stock_Symbol.equals(MsgProperties.G9999KG)) {
                return G999p;
            } else {
                return "";
            }
        }
        return "";

    }

    public static String getTypeGoldNoPercent(String Stock_Symbol) {
        if (Stock_Symbol != null) {
            if (Stock_Symbol.equals(MsgProperties.G965B)) {
                return G965;
            } else if (Stock_Symbol.equals(MsgProperties.G9999KG)) {
                return G999;
            } else {
                return "";
            }
        }
        return "";
    }


    public static String Mod(String aNum, String bNum) {
        int VOLUME1 = NumberUtil.parseInteger(aNum.replace(",", ""));
        int VOLUME2 = NumberUtil.parseInteger(bNum.replace(",", ""));
        int ans = 0;
        if (VOLUME1 > 0 && VOLUME2 > 0) {
            ans = VOLUME1 % VOLUME2;
        }
        return String.valueOf(ans);
    }

    public static String ModLost965(String aNum, String bNum) {
        int VOLUME1 = NumberUtil.parseInteger(aNum.replace(",", ""));
        int VOLUME2 = NumberUtil.parseInteger(bNum.replace(",", ""));
        int ans = 0;
        if (VOLUME1 > 0 && VOLUME2 > 0) {
            ans = VOLUME1 % VOLUME2;
        }
        return String.valueOf(ans);
    }

    public static double RoundNumbers5_0(double num) {
        if (num != Double.NaN && num > 0) {
//            if(num.contains("[.]")) {
            // = num.substring(0, num.indexOf("."));
            double ModNum = num % 10;
            if (ModNum == 0.00) {
                return num;
            } else if (ModNum == 5.00) {
                return num;
            } else if (ModNum > 5.00) {
                return num - ModNum + 5.00;
            } else {
                return num - ModNum;
            }
//            }
        }
        return num;
    }

    public static String RoundNumbers5_0(String num) {
        if (num != null) {
//            if(num.contains("[.]")) {
            // = num.substring(0, num.indexOf("."));
            double ModNum = Double.parseDouble(Mod(num, "10"));
            if (ModNum == 0.00) {
                return num;
            } else if (ModNum == 5.00) {
                return num;
            } else if (ModNum > 5.00) {
                return String.valueOf(Double.parseDouble(num) - ModNum + 5.00);
            } else {
                return String.valueOf(Double.parseDouble(num) - ModNum);
            }
//            }
        }
        return "0";
    }

    public static String convertStringTimeToHHmmWithColon(String fullTimeWithColon) {
        String[] splittedTime = fullTimeWithColon.split(":");
        String timeInHHmm = splittedTime[0] + ":" + splittedTime[1];
        return timeInHHmm;
    }

    public static String splitTimeToHHmmss(String fullTimeWithColon) {
        String[] splittedTime = fullTimeWithColon.split(":");
        String timeInHHmmss = splittedTime[0] + splittedTime[1] + splittedTime[2];
        return timeInHHmmss;
    }

    public static void addCommaInEditText2(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);
                try {
                    String givenstring = s.toString();
                    Long longval;
                    if (givenstring.contains(",")) {
                        givenstring = givenstring.replaceAll(",", "");
                    }
                    longval = Long.parseLong(givenstring.equals("") ? MsgProperties.ZERO : givenstring);
                    DecimalFormat formatter = new DecimalFormat("#,###,###");
                    String formattedString = formatter.format(longval);
                    if (givenstring.equals("")) {
                        editText.setText("");
                    } else {
                        editText.setText(formattedString);
                        editText.setSelection(editText.getText().length());
                    }

                    // to place the cursor at the end of text

                    editText.addTextChangedListener(this);

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void addCommaInEditText(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);
                try {
                    String givenstring = s.toString();
                    Long longval;
                    if (givenstring.contains(",")) {
                        givenstring = givenstring.replaceAll(",", "");
                    }
                    longval = Long.parseLong(givenstring.equals("") ? MsgProperties.ZERO : givenstring);
                    DecimalFormat formatter = new DecimalFormat("#,###,###");
                    String formattedString = formatter.format(longval);
                    editText.setText(formattedString.equalsIgnoreCase(MsgProperties.ZERO) ? MsgProperties.EMPTY : formattedString);
//                    editText.setText(formattedString);
                    editText.setSelection(editText.getText().length());
                    // to place the cursor at the end of text

                    editText.addTextChangedListener(this);

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void detectInputPin(CompoundButton cbPin) {
        if (cbPin != null && CheckTable.indexOf(cbPin) < 0) {
            Activity A = systemInfo.getMainActivity();
            final Context mContext = A.getApplicationContext();
            CheckTable.add(cbPin);
            cbPin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (!isChecked) {
                        Logon.Instance().SetPin(MsgProperties.EMPTY, null);
                    } else {
                        buttonView.setChecked(Logon.Instance().RememberPin);
                    }
                }
            });

            cbPin.setChecked(Logon.Instance().RememberPin);

        }

    }

    public static void ClearDetectPin() {
        if (CheckTable != null) {
            CheckTable.clear();
        }
        if (PassTable != null) {
            PassTable.clear();
        }
    }

    public static void NextFocusEdtLastSelection(EditText onclick, final EditText onfocus) {
        if (onclick != null && onfocus != null) {

            onclick.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_NEXT) {
                        onfocus.requestFocus();
                        if (onfocus.length() > 0) {
                            onfocus.setSelection(onfocus.getText().length());
                        }
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /**
     * New Change Pin
     */
    public static void detectInputRememberPin(final EditText editText) {
        if (editText != null && PassTable.indexOf(editText) < 0) {
            PassTable.add(editText);
            Log.d("Pin_Remember", "PassTable = [" + PassTable + "]");
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s != null) {
                        String Cha = s.toString();
                        Logon.Instance().RememberPin(Cha, editText);
                        Log.d("Pin_Remember", "Detect Input Pin = [" + Cha + "]");
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            editText.setText(Logon.Instance().Pin);
            if (editText.getText().length() > 0) {
                editText.setSelection(editText.getText().length());
            }

        }


    }

    public static void detectInputPin(final EditText editText) {
        if (editText != null && PassTable.indexOf(editText) < 0) {
            PassTable.add(editText);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s != null) {
                        String Cha = s.toString();
                        Logon.Instance().SetPin(Cha, editText);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            editText.setText(Logon.Instance().Pin);
            if (editText.getText().length() > 0) {
                editText.setSelection(editText.getText().length());
            }

        }


    }

    public static boolean checkURL(CharSequence input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(input).matches();
        if (!isURL) {
            String urlString = input + "";
            if (URLUtil.isNetworkUrl(urlString)) {
                try {
                    new URL(urlString);
                    isURL = true;
                } catch (Exception e) {
                }
            }
        }
        return isURL;
    }

    // getting the maximum value
    public static int getMaxValue(ArrayList<Integer> array) {
        int maxValue = 0;
        if (array != null) {
//            maxValue = array.get(0);
//            for (int i = 1; i < array.size(); i++) {
//                if (array.get(i) > maxValue) {
//                    maxValue = array.get(i);
//                }
//            }
            maxValue = Collections.max(array);
        }
        return maxValue;
    }
}    /**
 * end
 */

