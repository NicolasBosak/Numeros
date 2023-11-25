import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class Ventana {
    private JPanel Numeros;
    private JButton btnNumeros;
    private JList list1;
    private JButton btnSumar;
    private JTextArea textArea1;
    private JSpinner spnAzar;
    private JList lstnodos;
    private JSpinner spnEliminar;
    private DefaultListModel<Integer> listModel;

    public Ventana() {
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);
        btnNumeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int limite = (int) spnEliminar.getValue();
                int count = (int) spnAzar.getValue();
                Lista lista = new Lista();
                ArrayList<Integer> numeros = lista.generarNumeros(count);
                DefaultListModel newListModel = new DefaultListModel();
                DefaultListModel nodosListModel = new DefaultListModel();
                for (int i = 0; i < numeros.size(); i++) {
                    int numero = numeros.get(i);
                    if (numero <= limite) {
                        newListModel.addElement(numero);
                    } else {
                        nodosListModel.addElement(numero);
                    }
                }
                list1.setModel(newListModel);
                lstnodos.setModel(nodosListModel);
            }
        });
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel list1Model = (DefaultListModel) list1.getModel();
                Enumeration<Integer> list1Elementos = list1Model.elements();
                Lista listaList1 = new Lista();
                int sumList1 = listaList1.sumarNumeros(list1Elementos);
                DefaultListModel nodosListModel = (DefaultListModel) lstnodos.getModel();
                Enumeration<Integer> nodosElementos = nodosListModel.elements();
                Lista listaNodos = new Lista();
                int sumNodos = listaNodos.sumarNumeros(nodosElementos);
                int sumTotal = sumList1 + sumNodos;
                textArea1.setText("La suma de los numeros aleatorios generados es: " + sumList1 + "\n");
                textArea1.append("La suma de los numeros eliminados es: " + sumNodos + "\n");
                textArea1.append("La suma total es: " + sumTotal + "\n");
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Numeros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}