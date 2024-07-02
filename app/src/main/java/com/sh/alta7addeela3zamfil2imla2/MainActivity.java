package com.sh.alta7addeela3zamfil2imla2;


import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView i2;
    Mydatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.secondaire));
        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
        i2=findViewById(R.id.logo);

        Animation a1= AnimationUtils.loadAnimation(this, R.anim.logo_mainactivity);
        a1.setDuration(2000);
        i2.setAnimation(a1);
        sqldb=new Mydatabase(MainActivity.this);
        sqldb.deleteallquestions();

        if((sqldb.getquestionscount())==0) {
            sqldb.deleteallquestions();
            readExcelFromAssets(this, "questions.xls");
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent (MainActivity.this,ownerinfoActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    public void readExcelFromAssets(final Context context, final String fileName) {
        try {

            AssetManager assetManager = context.getAssets();

            InputStream inputStream = assetManager.open(fileName);

            Workbook workbook= WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            // Starting from the second row (index 1) to skip the header row
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Read data from each column
                String question = getCellValueAsString(row.getCell(1));
                String rightAnswer = getCellValueAsString(row.getCell(2));
                String false1 = getCellValueAsString(row.getCell(3));
                String false2 = getCellValueAsString(row.getCell(4));
                String false3 = getCellValueAsString(row.getCell(5));
                String lesson = getCellValueAsString(row.getCell(6));
                String lamp = getCellValueAsString(row.getCell(7));
                String category = getCellValueAsString(row.getCell(8));

                // Assuming sqldb.insertquestionform() is a method that correctly inserts into your database
                sqldb.insertquestionform(new questionform(false1, false2, false3, lesson, question,lamp, rightAnswer, category));
            }
            workbook.close();
            inputStream.close();
            Log.d("ExcelReader", "Data inserted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ExcelReader",  ""+e);
            // Show toast on UI thread
            new Handler(context.getMainLooper()).post(() -> Toast.makeText(context, "Error reading Excel file: " + e.getMessage(), Toast.LENGTH_SHORT).show());

        }
    }
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null; // Return null if cell is null
        }

        // Handle different cell types appropriately
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return ""; // Handle blank cells as empty strings
            default:
                return ""; // Return null for unsupported cell types
        }
    }
}
