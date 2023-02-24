package com.tri.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Menus extends AppCompatActivity {
    TextView tvContextMenu;
    Button btnPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        tvContextMenu = findViewById(R.id.tvContextMenu);
        btnPopupMenu = findViewById(R.id.btnPopupMenu);

        registerForContextMenu(tvContextMenu);

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(Menus.this, btnPopupMenu);
                popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.option_forward:
                                toPopupMenu();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popup.show();
            }
        });
    }

    private void toPopupMenu() {
        Intent toPopupMenu = new Intent(this, Popup.class);
        startActivity(toPopupMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void toOptionMenu() {
        Intent toOptionMenu = new Intent(this, OptionMenu.class);
        startActivity(toOptionMenu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_settings:
            case R.id.option_favorites:
                toOptionMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    private void toContextMenu() {
        Intent toContextMenu = new Intent(this, Context.class);
        startActivity(toContextMenu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit:
            case R.id.context_share:
                toContextMenu();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}