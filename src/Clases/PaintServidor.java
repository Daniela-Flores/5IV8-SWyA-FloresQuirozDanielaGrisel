/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Danielao.0
 */
public class PaintServidor extends JPanel{
    
    JPanel panel;
    Lienzo lienzo;
    JButton borrar, rojo, azul, amarillo, verde, negro, marron;
    public PaintServidor(String ip){      
        super.setBounds(0, 0,800, 300);
        super.setBackground(Color.YELLOW);
        super.setVisible(true);
        super.setLayout(null);
        lienzo=new Lienzo(true,ip);
        super.add(lienzo);        
        borrar= new JButton("Borrar");
        borrar.setBounds(Constantes.HEIGHT-10, 10,70, 30);
        borrar.setVisible(true);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=0;
            }
        });
        super.add(borrar);
        negro= new JButton("Negro");
        negro.setBounds(Constantes.HEIGHT-10, 110,70, 30);
        negro.setVisible(true);
        negro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=1;
            }
        });
        super.add(negro);
        rojo= new JButton("Rojo");
        rojo.setBounds(Constantes.HEIGHT-10, 140,70, 30);
        rojo.setVisible(true);
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=2;
            }
        });
        super.add(rojo);
        azul= new JButton("Azul");
        azul.setBounds(Constantes.HEIGHT-10, 170,70, 30);
        azul.setVisible(true);
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=3;
            }
        });
        super.add(azul);
        amarillo= new JButton("Amarillo");
        amarillo.setBounds(Constantes.HEIGHT-10, 200,70, 30);
        amarillo.setVisible(true);
        amarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=4;
            }
        });
        super.add(amarillo);
        verde= new JButton("Verde");
        verde.setBounds(Constantes.HEIGHT-10, 230,70, 30);
        verde.setVisible(true);
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=5;
            }
        });
        super.add(verde);
        
        marron= new JButton("Fucsia");
        marron.setBounds(Constantes.HEIGHT-10, 260,70, 30);
        marron.setVisible(true);
        marron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=6;
            }
        });
        super.add(marron);
    }
}
