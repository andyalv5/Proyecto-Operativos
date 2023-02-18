/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
/**
 *
 * @author Andy
 */
public class lol {
    
// Create a simple pie chart
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    pieDataset.setValue("Ubuntu", new Integer(75));
    pieDataset.setValue("Xubuntu", new Integer(10));
    pieDataset.setValue("Kubuntu", new Integer(10));
    pieDataset.setValue("Otros", new Integer(5));
    JFreeChart chart = ChartFactory.createPieChart(
    "Sistemas Operativos",
    pieDataset,
    true,
    true,
    false);
    try {
    ChartUtilities.saveChartAsJPEG(new File("/home/jose/Desktop/PieChart.jpg"), chart, 500,
    300);
    } catch (Exception e) {
    System.out.println("Error creando grafico.");
    }

}
