import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    private Container Jmain;
    private JLabel JLN1,JLN2,JLN3,JLN4,JLN5;
    private JTextField textField1,textField2,textField3,textField4,textField5;
    private JButton btCalcular, btLimpiar;


    private JLabel Jpromedio;
    private JLabel Jdesviacion;
    private JLabel Jmayor;
    private JLabel Jmenor;

    public VentanaPrincipal(){
        inicio();
        setTitle("Notas");
        setSize(280,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio(){
        Jmain = getContentPane();
        Jmain.setLayout(null);

        JLN1 = new JLabel();
        JLN1.setText("Nota 1");
        JLN1.setBounds(20,20,135,23);
        textField1 = new JTextField();
        textField1.setBounds(105,20,135,23);

        JLN2 = new JLabel();
        JLN2.setText("Nota 2");
        JLN2.setBounds(20,50,135,23);
        textField2 = new JTextField();
        textField2.setBounds(105,50,135,23);

        JLN3 = new JLabel();
        JLN3.setText("Nota 3");
        JLN3.setBounds(20,80,135,23);
        textField3 = new JTextField();
        textField3.setBounds(105,80,135,23);

        JLN4 = new JLabel();
        JLN4.setText("Nota 4");
        JLN4.setBounds(20,110,135,23);
        textField4 = new JTextField();
        textField4.setBounds(105,110,135,23);

        JLN5 = new JLabel();
        JLN5.setText("Nota 5");
        JLN5.setBounds(20,140,135,23);
        textField5 = new JTextField();
        textField5.setBounds(105,140,135,23);

        btCalcular = new JButton();
        btCalcular.setText("Calcular");
        btCalcular.setBounds(20,170,100,23);
        btCalcular.addActionListener(this);

        btLimpiar = new JButton();
        btLimpiar.setText("Limpiar");
        btLimpiar.setBounds(125,170,80, 23);
        btLimpiar.addActionListener(this);


        Jpromedio = new JLabel();
        Jpromedio.setText("Promedio =");
        Jpromedio.setBounds(20,210,135,23);

        Jdesviacion = new JLabel();
        Jdesviacion.setText("Desviación =");
        Jdesviacion.setBounds(20,240,200,23);

        Jmayor = new JLabel();
        Jmayor.setText("Nota mayor =");
        Jmayor.setBounds(20,270,120,23);

        Jmenor = new JLabel();
        Jmenor.setText("Nota menor =");
        Jmenor.setBounds(20,300,120,23);

        Jmain.add(JLN1);
        Jmain.add(textField1);
        Jmain.add(JLN2);
        Jmain.add(textField2);
        Jmain.add(JLN3);
        Jmain.add(textField3);
        Jmain.add(JLN4);
        Jmain.add(textField4);
        Jmain.add(JLN5);
        Jmain.add(textField5);
        Jmain.add(btCalcular);
        Jmain.add(btLimpiar);
        Jmain.add(Jpromedio);
        Jmain.add(Jdesviacion);
        Jmain.add(Jmayor);
        Jmain.add(Jmenor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btCalcular){
            Notas notas = new Notas();
            notas.listaNotas[0] = Double.parseDouble(textField1.getText());
            notas.listaNotas[1] = Double.parseDouble(textField2.getText());
            notas.listaNotas[2] = Double.parseDouble(textField3.getText());
            notas.listaNotas[3] = Double.parseDouble(textField4.getText());
            notas.listaNotas[4] = Double.parseDouble(textField5.getText());
            notas.calcularPromedio();
            notas.calcularDesviación();
            Jpromedio.setText("Promedio = "+String.valueOf(String.format("%.2f",notas.calcularPromedio())));
            double desv = notas.calcularDesviación();
            Jdesviacion.setText("Desviacion = "+String.valueOf(String.format("%.2f",desv)));
            Jmayor.setText("Valor mayor = "+ String.valueOf(notas.calcularMayor()));
            Jmenor.setText("Valor menor = "+ String.valueOf(notas.calcularMenor()));
        }

        if(evento.getSource() == btLimpiar){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
