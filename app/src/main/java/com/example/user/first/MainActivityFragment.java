package com.example.user.first;

import android.icu.math.BigDecimal;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.first.Database.AppStorage;
import com.example.user.first.Database.Entity.Group;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    TextView mText;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    ImageButton delete;
    Button clear;
    Spinner spinner1;
    ArrayAdapter<CharSequence> adapter;

    boolean secondss = false;
    BigDecimal first = BigDecimal.ZERO;
    BigDecimal second = BigDecimal.ZERO;
    BigDecimal result;
    int opcode;
    int position=-1;
    public MainActivityFragment() {
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);


        mText = (TextView) view.findViewById(R.id.text);
        button = (Button) view.findViewById(R.id.button);
        button1 = (Button) view.findViewById(R.id.button2);
        button2 = (Button) view.findViewById(R.id.button3);
        button3 = (Button) view.findViewById(R.id.button4);
        button4 = (Button) view.findViewById(R.id.button5);
        button5 = (Button) view.findViewById(R.id.button6);
        button6 = (Button) view.findViewById(R.id.button7);
        button7 = (Button) view.findViewById(R.id.button8);
        button8 = (Button) view.findViewById(R.id.button9);
        button9 = (Button) view.findViewById(R.id.button10);
        button10 = (Button) view.findViewById(R.id.button11);
        button11 = (Button) view.findViewById(R.id.button12);
        button12 = (Button) view.findViewById(R.id.button13);
        button13 = (Button) view.findViewById(R.id.button14);
        button14 = (Button) view.findViewById(R.id.button15);
        button15 = (Button) view.findViewById(R.id.button16);
        delete = (ImageButton) view.findViewById(R.id.delete);
        clear= (Button) view.findViewById(R.id.clear);
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(MainActivity.getContext(),R.array.operation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    operations("+");
                }
                else if (position==1)
                {
                    operations("-");
                }
                else if (position==2)
                {
                    operations("x");
                }
                else
                {
                    if (position==4)
                    {
                        operations("/");
                    }
                }
/*
                switch (position)
                {
                    case '0':
                        operations("+");
                    break;
                    case '1':
                        operations("-");
                    break;
                    case '2':
                        operations("x");
                        break;
                    case '3' :
                        operations("/");
                    break;
                    default:
                        operations("+");
                }
*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        clear();
        return view;
    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        View.OnClickListener listenerNumber = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number(((Button) v).getText().toString());
                // text.setText(button.getText());
            }
        };
        View.OnClickListener listenerEQ = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equalsMet(((Button) v).getText().toString());
                // text.setText(button.getText());
            }
        };
        View.OnClickListener listenerOper = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations(((Button) v).getText().toString());
                // text.setText(button.getText());
            }
        };

        View.OnClickListener listenerPoint = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point(((Button) v).getText().toString());
                // text.setText(button.getText());
            }
        };

        button.setOnClickListener(listenerEQ);
        button1.setOnClickListener(listenerNumber);
        button2.setOnClickListener(listenerNumber);
        button3.setOnClickListener(listenerNumber);
        button4.setOnClickListener(listenerNumber);
        button5.setOnClickListener(listenerNumber);
        button6.setOnClickListener(listenerNumber);
        button7.setOnClickListener(listenerNumber);
        button8.setOnClickListener(listenerNumber);
        button9.setOnClickListener(listenerNumber);
        button10.setOnClickListener(listenerNumber);
        button11.setOnClickListener(listenerPoint);
        button12.setOnClickListener(listenerOper);
        button13.setOnClickListener(listenerOper);
        button14.setOnClickListener(listenerOper);
        button15.setOnClickListener(listenerOper);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLast();
            }
        });
    }
    public void clear()
    {
        secondss = false;
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        mText.setText("");

    }

    public void deleteLast() {
        String text = mText.getText().toString().trim();
        if (text.length() > 0) {

            text = text.substring(0, text.length() - 1);
            mText.setText(text);
        }
        else
        {
            return;
        }
        if (!text.contains("+") && !text.contains("-") && !text.contains("*") && !text.contains("/")) {
                secondss = false;
                second = BigDecimal.ZERO;
            }

        if (!secondss && text.length()==1) {
            first = BigDecimal.ZERO;
        }
            else if (!secondss && text.length()>1) {
            first = new BigDecimal(text);
        }
         else {
            if (secondss){
            second = new BigDecimal(second.toString().substring(0, second.toString().length() - 1));
        }}


    }

    private void point(String text) {

        if(mText.getText().toString().contains("-") ) {
            String[] array = mText.getText().toString().split("-");
            if (array.length == 2) {
                if (!array[1].contains(".")) {
                    mText.setText(mText.getText().toString() + ".");
                }
            }
            else {
              mText.setText(mText.getText().toString() + "0.");
            }
        }
        else if(mText.getText().toString().contains("+") ) {
            String s= mText.getText().toString().replace("+","plus");
            String[] array = s.toString().split("plus");
            if (array.length == 2) {
                if (!array[1].contains(".")) {
                    mText.setText(mText.getText().toString() + ".");
                }
            }
            else {
                mText.setText(mText.getText().toString() + "0.");
            }
        }
        else if (mText.getText().toString().contains("x") ) {
            String s= mText.getText().toString().replace("x","molt");
            String[] array = s.toString().split("molt");
            if (array.length == 2) {
                if (!array[1].contains(".")) {
                    mText.setText(mText.getText().toString() + ".");
                }
            }
            else {
                mText.setText(mText.getText().toString() + "0.");
            }
        }
        else if (mText.getText().toString().contains("/") ) {
            String[] array = mText.getText().toString().split("/");
            if (array.length == 2) {
                if (!array[1].contains(".")) {
                    mText.setText(mText.getText().toString() + ".");
                }
            }
            else {
                mText.setText(mText.getText().toString() + "0.");
            }
        }

        else if(!mText.getText().toString().contains(".") && !mText.getText().toString().isEmpty())
        {
                mText.setText(mText.getText().toString() + ".");

        }

        else {
         if(mText.getText().toString().isEmpty()){
          mText.setText("0.");

         }
        }
    }

    private void makeMessage(String s) {
        Snackbar.make(view, s, Snackbar.LENGTH_LONG);
    }

    public void operations(String text) {


        if (mText.getText().toString().contains("+") || mText.getText().toString().contains("-") || mText.getText().toString().contains("x") || mText.getText().toString().contains("/")) {
            makeMessage("Error ");
            return;

        }

        mText.setText(mText.getText() + text);

        if (text.equals("+")) {
            opcode = 1;
        } else if (text.equals("-")) {
            opcode = 2;
        } else if (text.equals("x")) {
            opcode = 3;
        } else {
            opcode = 4;
        }
        secondss = true;
    }

    public void equalsMet(String text) {
        Group group = new Group();
        if (opcode == 1) {
            String str= mText.getText().toString().replace("+","plus");
            String[] array =str.split("plus");
            result = new BigDecimal(array[0]).add(new BigDecimal(array[1]));
            String operation=("+");
        } else if (opcode == 2) {
            String[] array = mText.getText().toString().split("-");
            result = new BigDecimal(array[0]).subtract(new BigDecimal(array[1]));
            String operation=("-");
        } else if (opcode == 3) {
            String str= mText.getText().toString().replace("x","moltipl");
            String[] array =str.split("moltipl");
            result = new BigDecimal(array[0]).multiply(new BigDecimal(array[1]));
            String operation=("x");
        } else {
            String[] array= mText.getText().toString().split("/");
            result = new BigDecimal(array[0]).divide(new BigDecimal(array[1]));
            String operation=("/");
        }
        mText.setText(result.toString());


        String operation=String.valueOf(opcode);
        String primo= String.valueOf(first);
        String secondo= String.valueOf(second);
        String risultato= String.valueOf(result);



        group.setFirst(primo);
        group.setOperation(operation);
        group.setSecond(secondo);
        group.setResult(risultato);
        try {
            AppStorage.add(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Group> LG = AppStorage.getGroups();
        if(LG != null){

        }



    }



    public void number(String text) {

        if (secondss) {
            try {
                second = new BigDecimal(second + text);
                mText.setText(mText.getText() + text);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            try {
                first = new BigDecimal(first + text);
                mText.setText((mText.getText() + text));
            } catch (NumberFormatException e) {
            }
        }

    }

    private void resolveButton(String text) {
        //  if(text.contains("x"))

        mText.setText(mText.getText() + text);

    }

}
