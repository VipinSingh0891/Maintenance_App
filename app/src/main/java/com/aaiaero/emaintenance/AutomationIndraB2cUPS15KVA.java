package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AutomationIndraB2cUPS15KVA extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray ={};//Copy
    private Spinner[] spinnerArray={};//Copy

    private String thisActivityName = "AutomationIndraB2cUPS15KVA"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation_indra_b2c_ups15_kva);

        //Define and Initialize all EditTexts serially here
        EditText editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41;

        editTextArray =  new EditText[] {
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 =(EditText) findViewById(R.id.editText10),
                editText11 =(EditText)  findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 =(EditText)  findViewById(R.id.editText13),
                editText14 = (EditText) findViewById(R.id.editText14),
                editText15 = (EditText) findViewById(R.id.editText15),
                editText16 = (EditText) findViewById(R.id.editText16),
                editText17 = (EditText) findViewById(R.id.editText17),
                editText18 = (EditText) findViewById(R.id.editText18),
                editText19 = (EditText) findViewById(R.id.editText19),
                editText20 = (EditText) findViewById(R.id.editText20),
                editText21 = (EditText) findViewById(R.id.editText21),
                editText22 = (EditText) findViewById(R.id.editText22),
                editText23 = (EditText) findViewById(R.id.editText23),
                editText24 = (EditText) findViewById(R.id.editText24),
                editText25 = (EditText) findViewById(R.id.editText25),
                editText26 = (EditText) findViewById(R.id.editText26),
                editText27 = (EditText) findViewById(R.id.editText27),
                editText28 = (EditText) findViewById(R.id.editText28),
                editText29 = (EditText) findViewById(R.id.editText29),
                editText30 = (EditText) findViewById(R.id.editText30),
                editText31 =(EditText)  findViewById(R.id.editText31),
                editText32 = (EditText) findViewById(R.id.editText32),
                editText33 =(EditText)  findViewById(R.id.editText33),
                editText34 = (EditText) findViewById(R.id.editText34),
                editText35 = (EditText) findViewById(R.id.editText35),
                editText36 = (EditText) findViewById(R.id.editText36),
                editText37 = (EditText) findViewById(R.id.editText37),
                editText38 = (EditText) findViewById(R.id.editText38),
                editText39 = (EditText) findViewById(R.id.editText39),
                editText40 = (EditText) findViewById(R.id.editText40),
                editText41 = (EditText) findViewById(R.id.editText41)};


        //Define and Initialize all Switches serially here

        //Define and Initialize all Spinners serially here

        //---------------------To Set View in Current Activity------------------
        // Fixed for all the activity---------------------------------------------------------------
        //ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        //imageView2.setImageBitmap(PersonalDetailsActivity.photo);
        TextView textView3 = (TextView) findViewById(R.id.textView1);
        textView3.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView4 = (TextView) findViewById(R.id.textView2);
        textView4.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView5 = (TextView) findViewById(R.id.textView3);
        textView5.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView6 = (TextView) findViewById(R.id.textView4);
        textView6.setText("Location: " + MainActivity.latLong1);


        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        String strData = sdf.format(calendar.getTime());
        textViewDate.setText(strData);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            //String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            //String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            // String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            //String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            //myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            //myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button2) ;
        Button submitSchedule = (Button) findViewById(R.id.button1);

        submitSchedule.setVisibility(View.INVISIBLE);
        signDocument.setVisibility(View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);


            }
        });

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });
        // Fixed for all activity-------------------------------------------------------------------
    }

    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        //String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        //String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

        // String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

        //String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2c15kvaups1);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText("Name: " + PersonalDetailsActivity.naam ,1500,32,titlePaint);
        //canvas.drawText("Desig: " + PersonalDetailsActivity.design ,1500,64,titlePaint);
        //canvas.drawText("Emp No.: " + PersonalDetailsActivity.EmpID ,1500,96,titlePaint);
        //canvas.drawText("Location: " + MainActivity.latLong1,1500,128,titlePaint);
        //canvas.drawBitmap(PersonalDetailsActivity.photo, 1630, 130, paint);
        //--------------------------------Change as per your requirement------------------------------------------------------
        // canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,500,510, false), 1325, 2720, paint);
        titlePaint.setTextSize(12);

        int[] editTextXPixel1 = {620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620,620};
        int[] editTextYPixel1 = {262,279,296,331,349,365,382,401,419,435,454,471,505,523,539,558,575,592,609,627,644,680,697,714,732,749,766,784,800,817,852,869,888,905};

        //int[] switchXPixel = {1400,1400,1400,1400,1400,1400,1400,1400,1400,1400,1400};
        //int[] switchYPixel = {645,768,809,950,1623,2023,2190,2319,2403,2530,2660};

        //int[] spinnerXPixel = {1400,1400,1400,1400,1400,1400,1400,1400,1400};
        //int[] spinnerYPixel = {1070,1143,1216,1289,1362,1435,1550,1690,1901};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        /*for(int i = 0; i < switchDataForPDF.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }

        for(int i = 0; i < spinnerDataForPDF.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
        }*/


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,593,227,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2c15kvaups2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {620,620,620,620,620,442};
        int[] editTextYPixel2 = {126,144,161,179,196,236};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo, 210, 270, false), 93, 480, paint);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 290, 270, false), 22, 296, paint);
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Automation/Indra/B2c/UPS_15KVA/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Automation B2C UPS 15 KVA " + strData + ".pdf"; // Change Here--------------------------
        String targetPdf = directory_path + fileName;
        File filePath = new File(targetPdf);
        try {
            myPdfdocument.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            //done = true;
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfdocument.close();
        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());// Change Here----------------------------
        //This function saves all the data to parse Server
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"Automation","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "UPS 15KVA Maintenance of Automation Indra B2c done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);


        myFunctions.toLogoutActivity();

    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final EditText desiredFormName = (EditText)mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = findViewById(R.id.putInDB);
                        String formName = desiredFormName.getText().toString();
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName, thisActivityName);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;

            case R.id.deleteFromDB:
                View view1 = findViewById(R.id.deleteFromDB);
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete Alert")
                        .setMessage("Do you really want to delete this entry permanently from Local DB?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myFunctions.deleteFromDB(view1, selectedID, selectedName);
                                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }
}