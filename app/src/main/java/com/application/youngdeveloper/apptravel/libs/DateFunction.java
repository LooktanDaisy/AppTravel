package com.application.youngdeveloper.apptravel.libs;

import android.annotation.SuppressLint;
import android.util.Log;

import com.fg.mdp.psi.goldspot.dataModel.msgMK;
import com.fg.mdp.psi.goldspot.msg.MsgProperties;
import com.mdp.core.util.NumberUtil;
import com.mdp.core.util.StringUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import flex.messaging.services.messaging.selector.ParseException;

/**
 * Created by Suphadate_Noy on 7/15/2016.
 */
public class DateFunction {
    public static final String fyyyyMMdd = "yyyyMMdd";

    public static String changeFormatDateENGtoThaiFormat(String DateMsq) {
        if (DateMsq != null) {
            String Months[] = {
                    "ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.",
                    "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.",
                    "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค."};

            String D = DateMsq.substring(0, 2);
            String M = DateMsq.substring(3, 6);
            String Y = DateMsq.substring(7);

            int yInt = 2543 + Integer.parseInt(Y);
            Y = String.valueOf(yInt);

            if (M.equals("Jan")) {
                return D.toString() + " " + Months[0].toString() + " " + Y.toString();
            } else if (M.equals("Feb")) {
                return D.toString() + " " + Months[1].toString() + " " + Y.toString();
            } else if (M.equals("Mar")) {
                return D.toString() + " " + Months[2].toString() + " " + Y.toString();
            } else if (M.equals("Aug")) {
                return D.toString() + " " + Months[3].toString() + " " + Y.toString();
            } else if (M.equals("Apr")) {
                return D.toString() + " " + Months[4].toString() + " " + Y.toString();
            } else if (M.equals("May")) {
                return D.toString() + " " + Months[5].toString() + " " + Y.toString();
            } else if (M.equals("Jun")) {
                return D.toString() + " " + Months[6].toString() + " " + Y.toString();
            } else if (M.equals("Jul")) {
                return D.toString() + " " + Months[7].toString() + " " + Y.toString();
            } else if (M.equals("Sep")) {
                return D.toString() + " " + Months[8].toString() + " " + Y.toString();
            } else if (M.equals("Oct")) {
                return D.toString() + " " + Months[9].toString() + " " + Y.toString();
            } else if (M.equals("Nov")) {
                return D.toString() + " " + Months[10].toString() + " " + Y.toString();
            } else if (M.equals("Dec")) {
                return D.toString() + " " + Months[11].toString() + " " + Y.toString();
            } else {
                return "";
            }

        }
        return "";
    }

    public static String changeFormatDateENGtoNumberFomat(String DateMsq) {
        if (DateMsq != null) {
            String Months[] = {
                    "01", "02", "03", "04",
                    "05", "06", "07", "08",
                    "09", "10", "11", "12"};

            String D = DateMsq.substring(0, 2);
            String M = DateMsq.substring(3, 6);
            String Y = DateMsq.substring(7, 9);

//            int yInt = 2543 + Integer.parseInt(Y);
            int yInt = 2000 + Integer.parseInt(Y);
            Y = String.valueOf(yInt);

            if (M.equals("Jan")) {
                return D.toString() + "/" + Months[0].toString() + "/" + Y.toString();
            } else if (M.equals("Feb")) {
                return D.toString() + "/" + Months[1].toString() + "/" + Y.toString();
            } else if (M.equals("Mar")) {
                return D.toString() + "/" + Months[2].toString() + "/" + Y.toString();
            } else if (M.equals("Apr")) {
                return D.toString() + "/" + Months[3].toString() + "/" + Y.toString();
            } else if (M.equals("May")) {
                return D.toString() + "/" + Months[4].toString() + "/" + Y.toString();
            } else if (M.equals("Jun")) {
                return D.toString() + "/" + Months[5].toString() + "/" + Y.toString();
            } else if (M.equals("Jul")) {
                return D.toString() + "/" + Months[6].toString() + "/" + Y.toString();
            } else if (M.equals("Aug")) {
                return D.toString() + "/" + Months[7].toString() + "/" + Y.toString();
            } else if (M.equals("Sep")) {
                return D.toString() + "/" + Months[8].toString() + "/" + Y.toString();
            } else if (M.equals("Oct")) {
                return D.toString() + "/" + Months[9].toString() + "/" + Y.toString();
            } else if (M.equals("Nov")) {
                return D.toString() + "/" + Months[10].toString() + "/" + Y.toString();
            } else if (M.equals("Dec")) {
                return D.toString() + "/" + Months[11].toString() + "/" + Y.toString();
            } else {
                return "";
            }

        }
        return "";
    }

    public static String changeNumberToNumberFormat(String Date) {
        if (Date != null && Date.length() > 7) {
            String Months[] = {
                    "01", "02", "03", "04",
                    "05", "06", "07", "08",
                    "09", "10", "11", "12"};

            String D = Date.substring(6, 8);
            String M = Date.substring(4, 6);
            String Y = Date.substring(0, 4);

//            int yInt = Integer.parseInt(Y);
            //int yInt = 2543 + Integer.parseInt    (Y);

//            Y = String.valueOf(yInt + 543).substring(2, 4);

            if (M.equals("01")) {
                return D.toString() + "/" + Months[0].toString() + "/" + Y.toString();
            } else if (M.equals("02")) {
                return D.toString() + "/" + Months[1].toString() + "/" + Y.toString();
            } else if (M.equals("03")) {
                return D.toString() + "/" + Months[2].toString() + "/" + Y.toString();
            } else if (M.equals("04")) {
                return D.toString() + "/" + Months[3].toString() + "/" + Y.toString();
            } else if (M.equals("05")) {
                return D.toString() + "/" + Months[4].toString() + "/" + Y.toString();
            } else if (M.equals("06")) {
                return D.toString() + "/" + Months[5].toString() + "/" + Y.toString();
            } else if (M.equals("07")) {
                return D.toString() + "/" + Months[6].toString() + "/" + Y.toString();
            } else if (M.equals("08")) {
                return D.toString() + "/" + Months[7].toString() + "/" + Y.toString();
            } else if (M.equals("09")) {
                return D.toString() + "/" + Months[8].toString() + "/" + Y.toString();
            } else if (M.equals("10")) {
                return D.toString() + "/" + Months[9].toString() + "/" + Y.toString();
            } else if (M.equals("11")) {
                return D.toString() + "/" + Months[10].toString() + "/" + Y.toString();
            } else if (M.equals("12")) {
                return D.toString() + "/" + Months[11].toString() + "/" + Y.toString();
            } else {
                return "";
            }
        }
        return "";

    }

    public static String CurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return (dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
    }

    public static String Currentdate() {
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        Calendar cal = Calendar.getInstance();
        return (dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
    }

    public static String CurrentdateYYYYMMdd() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
        Calendar cal = Calendar.getInstance();
        return (dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
    }

    public static String CurrentdateSetFormate(String fomat) {
        DateFormat dateFormat = new SimpleDateFormat(fomat);
        Calendar cal = Calendar.getInstance();
        return (dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
    }

    public static long getTimestampCurrent() {
        String format = "yyyyMMdd";
        Calendar cal = Calendar.getInstance();
        cal.setTime(convertStringDateToDate(CurrentdateSetFormate(format), format));
        return cal.getTimeInMillis(); //2014/08/06 16:00:22

    }

    public static ArrayList<Long> getTimestampCurrent24hr() {
        String Date = msgMK.Instance().Market_Date;
        ArrayList<Long> timestamp24hr = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        if (Date != null && Date.length() > 7) {
            String D = Date.substring(6, 8);
            String M = Date.substring(4, 6);
            String Y = Date.substring(0, 4);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.DATE, NumberUtil.parseInteger(D) - 1);
            cal.set(Calendar.MONTH, NumberUtil.parseInteger(M) - 1);
            cal.set(Calendar.YEAR, NumberUtil.parseInteger(Y));
            for (int hourInDay = 0; hourInDay < 24; hourInDay++) {
                cal.add(Calendar.HOUR_OF_DAY, 1);
                timestamp24hr.add(hourInDay, cal.getTimeInMillis());

                Log.d("Graph_MAIN_SCREEN", "[" + hourInDay + "]" + String.valueOf(cal.getTime()));
            }

        }


        return timestamp24hr;

    }

    public static long convertDateToTimestamp(String str_date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        if (str_date != null) {
            try {
                Date date = sdf.parse(str_date);
                calendar.setTime(date);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
        return calendar.getTimeInMillis();

    }

    public static Date convertStringDateToDate(String str_date, String fomat) {
        SimpleDateFormat sdf = new SimpleDateFormat(fomat);
        Date date = null;
        if (str_date != null) {
            try {
                date = sdf.parse(str_date);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
        return date;

    }

    public static String CurrentDateThaiFormat() {
        @SuppressLint("SimpleDateFormat")
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return changeNumberToThaiFormat(dateFormat.format(date));
    }
    public static String CurrentDateNumberFormat() {
        @SuppressLint("SimpleDateFormat")
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return changeNumberToNumberFormat(dateFormat.format(date));
    }
    public static String SplitBackSlashSortdateyyyyMMdd(String date) {
        String Date = null;
        if (date != null) {
            if (date.contains("/")) {
                String[] splitDate = date.split("/");
                Date = splitDate[2] + splitDate[1] + splitDate[0];
            }
        }
        return Date;
    }

    public static String changeNumberToThaiFormat(String Date) {

//        Log.d("DATEFUNCTION","Date : "+Date);
        if (Date != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            try {
                if (Date.equals(dateFormat.format(dateFormat.parse(Date)))) {
                    String Months[] = {
                            "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน",
                            "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม",
                            "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"};

                    String D = Date.substring(6, 8);
                    String M = Date.substring(4, 6);
                    String Y = Date.substring(0, 4);

                    int yInt = +Integer.parseInt(Y);
                    //int yInt = 2543 + Integer.parseInt    (Y);

                    Y = String.valueOf(yInt + 543).substring(0, 4);

                    if (M.equals("01")) {
                        return D.toString() + " " + Months[0].toString() + " " + Y.toString();
                    } else if (M.equals("02")) {
                        return D.toString() + " " + Months[1].toString() + " " + Y.toString();
                    } else if (M.equals("03")) {
                        return D.toString() + " " + Months[2].toString() + " " + Y.toString();
                    } else if (M.equals("04")) {
                        return D.toString() + " " + Months[3].toString() + " " + Y.toString();
                    } else if (M.equals("05")) {
                        return D.toString() + " " + Months[4].toString() + " " + Y.toString();
                    } else if (M.equals("06")) {
                        return D.toString() + " " + Months[5].toString() + " " + Y.toString();
                    } else if (M.equals("07")) {
                        return D.toString() + " " + Months[6].toString() + " " + Y.toString();
                    } else if (M.equals("08")) {
                        return D.toString() + " " + Months[7].toString() + " " + Y.toString();
                    } else if (M.equals("09")) {
                        return D.toString() + " " + Months[8].toString() + " " + Y.toString();
                    } else if (M.equals("10")) {
                        return D.toString() + " " + Months[9].toString() + " " + Y.toString();
                    } else if (M.equals("11")) {
                        return D.toString() + " " + Months[10].toString() + " " + Y.toString();
                    } else if (M.equals("12")) {
                        return D.toString() + " " + Months[11].toString() + " " + Y.toString();
                    } else {
                        return "";
                    }
                }
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
        return "";

    }


    public static ArrayList<HashMap> sortOutstandingDateThenToMore(ArrayList<HashMap> myList) {
        if (myList != null) {
            if (myList.size() > 0) {
                Collections.sort(myList, new Comparator<HashMap>() {
                    @Override
                    public int compare(HashMap lhs, HashMap rhs) {
//                double x1 = NumberUtil.parseDouble(String.valueOf(lhs.get(MsgProperties.Order_Date_Noconvert)) +
//                        GenaralFunction.splitTimeToHHmmss(String.valueOf(lhs.get(MsgProperties.Order_Deal_Time))));
//                double x2 = NumberUtil.parseDouble(String.valueOf(rhs.get(MsgProperties.Order_Date_Noconvert)) +
//                        GenaralFunction.splitTimeToHHmmss(String.valueOf(rhs.get(MsgProperties.Order_Deal_Time))));
//                return (int) (x1 - x2);


                        double x1 = NumberUtil.parseDouble(String.valueOf(lhs.get(MsgProperties.Order_Date_Noconvert)) + StringUtil.PaddingLeft(String.valueOf(lhs.get(MsgProperties.Order_No)), 3, "0"));
                        double x2 = NumberUtil.parseDouble(String.valueOf(rhs.get(MsgProperties.Order_Date_Noconvert)) + StringUtil.PaddingLeft(String.valueOf(rhs.get(MsgProperties.Order_No)), 3, "0"));

                        //อันนี้เรียงวันที่ ล่าสุดมาก่อน
                        return (int) (x2 - x1);
                    }
                });
            }
        }
        return myList;
    }

    public static ArrayList<HashMap> sortDateThentoMore(ArrayList<HashMap> myList, final String sort) {
        if (myList != null) {
            if (myList.size() > 0) {
                Collections.sort(myList, new Comparator<HashMap>() {
                    @Override
                    public int compare(HashMap lhs, HashMap rhs) {
                        double x1 = NumberUtil.parseDouble(String.valueOf(lhs.get(sort)));
                        double x2 = NumberUtil.parseDouble(String.valueOf(rhs.get(sort)));
                        return (int) (x1 - x2);
//                return (int) (x2 - x1);
                    }
                });
            }
        }
        return myList;
    }

    public static ArrayList<HashMap> sortIDThentoMore(ArrayList<HashMap> myList, final String sort) {
        if (myList != null) {
            if (myList.size() > 0) {
                Collections.sort(myList, new Comparator<HashMap>() {
                    @Override
                    public int compare(HashMap lhs, HashMap rhs) {
                        double x1 = NumberUtil.parseDouble(String.valueOf(lhs.get(sort)));
                        double x2 = NumberUtil.parseDouble(String.valueOf(rhs.get(sort)));
//                        return (int) (x1 - x2);
                        return (int) (x2 - x1);
                    }
                });
            }
        }
        return myList;
    }


}
