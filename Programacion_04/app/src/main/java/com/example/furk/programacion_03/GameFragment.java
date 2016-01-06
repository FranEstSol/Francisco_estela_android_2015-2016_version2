package com.example.furk.programacion_03;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameFragment extends Fragment {

    //Dados
    ImageView red1;
    ImageView red2;
    ImageView blue1;
    ImageView blue2;
    ImageView blue3;
    ImageView greenDice;
    ImageView suma;
    ImageView resta;

    //Campos de texto
    TextView primerValor;
    TextView segundoValor;
    TextView signo;
    TextView resultado;

    //Valores de los dados generados
    int valorRojo1;
    int valorRojo2;
    int valorAzul1;
    int valorAzul2;
    int valorAzul3;
    int valorVerde;

    //Valor devuelto por los dados seleccionados
    int valorDevuelto =0;
    //Signo de la operacion seleccionada
    String operacionDevuelta=null;
    //Resultado total de la operacion actual sumado al numero anterior
    int total;

    //interruptor casero para seleccionar entre el primer y el segundo dijito al seleccionar un dado
    boolean position=true;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //"inflamos" el layout para el fragment, pero no lo devolvemos todavia.
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        //ASIGNACION DE IMAGENES
        //asignamos los dados a sus respectivas imagenes del XML
        red1 =(ImageView)view.findViewById(R.id.redDice1);
        red2 = (ImageView)view.findViewById(R.id.redDice2);

        blue1 = (ImageView)view.findViewById(R.id.blueDice1);
        blue2 = (ImageView)view.findViewById(R.id.blueDice2);
        blue3 = (ImageView)view.findViewById(R.id.blueDice3);

        greenDice = (ImageView)view.findViewById(R.id.bigDice);

        //Asignamos los simbolos de las operaciones
        suma = (ImageView)view.findViewById(R.id.plusSimbol);
        resta = (ImageView)view.findViewById(R.id.substractionSimbol);

        //ASIGNACION DE TEXTOS
        //Asignamos los campos de texto de resultados y signos
        primerValor = (TextView)view.findViewById(R.id.textViewValor1);
        segundoValor = (TextView)view.findViewById(R.id.textViewValor2);
        signo = (TextView)view.findViewById(R.id.textViewSigno);
        resultado = (TextView)view.findViewById(R.id.textViewResultado);

        //Llamada al metodo que genera los dados aleatorios
        createRandomDices();
        //Llamada al metodo que almacena los ClickListeners de los dados
        //(algo parecido a los getters y setters)
        diceClickContainer();
        //llamada al metodo que almacena los ClickListeners de los signos
        //(algo parecido a los getters y setters)
        simbolClickContainer();

        //Ahora si, devolvemos el view inflado
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //Metodo que genera los dados aleatorios
    private void createRandomDices() {
        //Se crean 3 arrays con todas las imagenes que pueden aparecer en cada tipo de dado
        int[]red = {R.drawable.red1,R.drawable.red2,R.drawable.red3};
        int[]blue = {R.drawable.blue1,R.drawable.blue2,R.drawable.blue3,R.drawable.blue4,R.drawable.blue5,R.drawable.blue6};
        int[]green = {
                R.drawable.green1,R.drawable.green2,R.drawable.green3,R.drawable.green4,
                R.drawable.green5,R.drawable.green6,R.drawable.green7,R.drawable.green8,
                R.drawable.green9,R.drawable.green10,R.drawable.green11,R.drawable.green12};

        //Se crea un objeto Random llamado "random"
        Random random = new Random();

        //Se crea una variable integer aleatoria entre los valores 0 y 2
        int redRandom = random.nextInt(3);
        //se le asigna a valoRojo1 su valor para despues poder hacer las operaciones con el
        valorRojo1 = redRandom +1;
        //Se le asigna al dado rojo1 una imagen, recibiendo desde (array"red"[valor"redRandom"])
        red1.setImageDrawable(getResources().getDrawable(red[redRandom]));
        //A la variable integer aleatoria creada arriba, se le asigna un nuevo valor random
        redRandom = random.nextInt(3);
        //se le asigna a valorRojo2 su valor para despues poder hacer las operaciones con el
        valorRojo2 = redRandom +1;
        //Se le asigna al dado rojo2 una imagen, recibiendo desde (array"red"[valor"redRandom"])
        red2.setImageDrawable(getResources().getDrawable(red[redRandom]));

        //Se repiten las mismas operaciones que en el dado rojo, dandole 6 valores posibles en lugar de 3
        int blueRandom = random.nextInt(6);
        valorAzul1 = blueRandom +1;
        blue1.setImageDrawable(getResources().getDrawable(blue[blueRandom]));
        blueRandom = random.nextInt(6);
        valorAzul2 = blueRandom +1;
        blue2.setImageDrawable(getResources().getDrawable(blue[blueRandom]));
        blueRandom = random.nextInt(6);
        valorAzul3 = blueRandom +1;
        blue3.setImageDrawable(getResources().getDrawable(blue[blueRandom]));

        //Se repiten las mismas operaciones que en el dado rojo, dandole 12 valores posibles en lugar de 3
        int greenRandom = random.nextInt(12);
        valorVerde = greenRandom +1;
        greenDice.setImageDrawable(getResources().getDrawable(green[greenRandom]));

    }

    //Metodo que almacena los ClickListeners de los dados
    private void diceClickContainer(){

        //Asignamos a la variable "valorDevuelto" el valor del dado correspondiente
        //Luego lo enviamos al metodo builder junto con la operacionDevuelta que, mientras
        //otro metodo no diga lo contrario, es null
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorDevuelto = valorRojo1;
                builder(valorDevuelto,operacionDevuelta);
            }
        });
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorDevuelto = valorRojo2;
                builder(valorDevuelto,operacionDevuelta);
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorDevuelto = valorAzul1;
                builder(valorDevuelto,operacionDevuelta);
            }
        });
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorDevuelto = valorAzul2;
                builder(valorDevuelto,operacionDevuelta);
            }
        });
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorDevuelto = valorAzul3;
                builder(valorDevuelto,operacionDevuelta);
            }
        });
    }

    //Metodo que almacena los ClickListeners de los signos
    private void simbolClickContainer(){

        //Asignamos a la variable "operacionDevuelta" el valor de la operacion seleccionada
        //Luego lo enviamos al metodo builder junto con el valorDevuelto que, mientras
        //otro metodo no diga lo contrario, es 0
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionDevuelta = "suma";
                builder(valorDevuelto,operacionDevuelta);
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionDevuelta = "resta";
                builder(valorDevuelto,operacionDevuelta);
            }
        });
    }

    //Metodo que monta los numeros y signos en sus respectivos lugares en los campos de texto
    private void builder(int valorDevuelto,String operacionDevuelta) {
        //Convertimos el valorDevuelto a un string para poder asignarlo al TextView
        String valor= String.valueOf(valorDevuelto);

        //Si la peracion devuelta es null, significa que has seleccionado un dado
        //Usamos position true para asignar el numero en el primer lugar
        if(position==true && operacionDevuelta == null){
            //Le asignamos al primer valor la variable valor
            primerValor.setText(valor);
            //cambiamos de estado "position" para que el siguiente dado lo asigne al segundo lugar
            position=false;
        }
        //Si la peracion devuelta es null, significa que has seleccionado un dado
        //Usamos position false para asignar el numero en el segundo lugar
        else if(position==false && operacionDevuelta == null){
            //Le asignamos al segundo valor la variable valor
            segundoValor.setText(valor);
            //Volvemos a cambiar el estado de "position" para que el siguiente dado sea asignado al primer lugar
            position=true;
            //Llamamos al metodo calcular, para calcular el resultado
            calcular();
        }
        //Si la peracion devuelta no es null, significa que has seleccionado un signo
        else if (operacionDevuelta != null){
            if(operacionDevuelta.equals("suma")){
                //Si la Operacion devuelta es una suma, asignamos el signo + al textView "signo"
                signo.setText("+");
                //Volvemos a poner como "null" la operacion devuelta, para poder seguir detectando dados
                this.operacionDevuelta = null;
            }
            else if (operacionDevuelta.equals("resta")){
                //Si la Operacion devuelta es una resta, asignamos el signo - al textView "signo"
                signo.setText("-");
                //Volvemos a poner como "null" la operacion devuelta, para poder seguir detectando dados
                this.operacionDevuelta = null;
            }
        }
    }

    //Metodo que calcula los resultados (incluidos el final)
    public void calcular(){
        //Cogemos los 2 valores de numeros del TextView y si no son barras bajas, seguimos
        //En caso de que 1 de los 2 fuese una barra baja el programa no haria nada
        if(!primerValor.getText().equals("_") &&!segundoValor.getText().equals("_")){
            //Comprobamos que se haya cambiado correctamente el signo.
            //En caso de que sea "{}" no hace nada
            if(!signo.getText().equals("{}")){
                //creamos 2 variables integer para recoger los valores desde los textView y
                //los convertimos en interger mediante el Integer.parseInt
                int primer = Integer.parseInt(primerValor.getText().toString());
                int second = Integer.parseInt(segundoValor.getText().toString());

                //Si es una suma
                if(signo.getText().equals("+")){
                    //Realizamos la suma final, que es el primer valor + el segundo + el total
                    total = primer+second+total;
                    //Creamos un String para poder visualizar el valor total
                    String operacionResultado = String.valueOf(total);
                    //Lo asignamos al TextView Resultado
                    resultado.setText(operacionResultado);
                }
                //Si es una resta
                else if (signo.getText().equals("-")){
                    //Realizamos la suma final, que es el primer valor - el segundo + el total
                    total = primer-second+total;
                    //Creamos un String para poder visualizar el valor total
                    String operacionResultado = String.valueOf(total);
                    //Lo asignamos al TextView Resultado
                    resultado.setText(operacionResultado);
                }
            }
        }
    }
}

