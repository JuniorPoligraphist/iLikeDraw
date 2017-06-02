package com.example.juniorpolygraphist.ilikedraw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;


public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = (DrawingView) findViewById(R.id.drawing_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                deleteDialog();
                break;

            case R.id.action_save:
                saveDrawingDialog();
                break;

            case R.id.action_about_app:
                initAboutActivity();
                break;

            case R.id.action_print:
                drawingView.printImage();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // call delete dialog
    private void deleteDialog() {
        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
        deleteDialog.setTitle(getString(R.string.delete_drawing));
        deleteDialog.setMessage(getString(R.string.new_drawing_warning));
        deleteDialog.setPositiveButton(getString(R.string.say_yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                drawingView.eraseAll();
                dialog.dismiss();

            }
        });
        deleteDialog.setNegativeButton(getString(R.string.say_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        deleteDialog.show();

    }


    // call save dialog
    public void saveDrawingDialog() {
        final AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
        saveDialog.setTitle(getString(R.string.save_drawing));
        saveDialog.setMessage(getString(R.string.save_drawing_in_gallery));
        saveDialog.setPositiveButton(getString(R.string.say_yes), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // call saveImage()
                drawingView.saveImage();
                dialog.dismiss();

            }
        });
        saveDialog.setNegativeButton(getString(R.string.say_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        saveDialog.show();
    }

    // add About app activity
    private void initAboutActivity() {
        new LibsBuilder()
                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                .withActivityTitle(getString(R.string.about_the_app))
                .withLibraries(getString(R.string.about_lib))
                .withVersionShown(true)
                .withAutoDetect(true)
                .withAboutIconShown(true)
                .withAboutAppName(getString(R.string.app_full_name))
                .withAboutVersionShownCode(true)
                .withAboutDescription(getString(R.string.app_description))
                .start(MainActivity.this);
    }
}

