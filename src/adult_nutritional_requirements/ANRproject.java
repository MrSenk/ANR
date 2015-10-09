package adult_nutritional_requirements;
import java.util.*;

/**
 * @author Camilo Cuevas
 */

public class ANRproject {
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Proceso Principal
        int mainOption;
        double imcAdult;
        
        mainOption = menuPrincipal();
        //Métodos según opción ingresada
        switch(mainOption){
            case 1:
                imcAdult = calcularImc();
                System.out.println("Su IMC es: "+imcAdult);
                condicionPaciente(imcAdult);
        }
    }
    
    public static int menuPrincipal(){
        //Primer menu de selección de rango de edad
        int mainMenu = 0;
        boolean ciclo = true;
        
        do{
            try{
                System.out.println("Indique la operación que desea realizar");
                System.out.println("1) Cálculo IMC Adulto");
                System.out.println("2) Calculo peso promedio aceptable del Adulto");
                System.out.println("3) Calculo peso promedio MÍNIMO aceptable del Adulto");
                System.out.println("4) Calculo peso promedio MÁXIMO aceptable del Adulto");
                System.out.println("5) Calcular peso ideal");
                System.out.println("6) Calcular requerimientos");
                System.out.print("Opción ingresada: ");
                mainMenu = input.nextInt();
                
                while(mainMenu<1 || mainMenu>6){
                    System.out.println("ERROR: Opción no válida, intente nuevamente");
                    System.out.print("Opción ingresada: ");
                    mainMenu = input.nextInt();
                }
                
                ciclo = false;
                
            }catch(InputMismatchException e){
                System.err.printf("\n ERROR: %s\n", e);
                input.nextLine();
                System.out.println("Sólo se aceptan valores numéricos");
            }
            
        }while(ciclo);
        
        return mainMenu;   
    }
    
    public static double calcularImc(){
        //Primera opcion: Calcular IMC
        double talla = 0;
        double peso = 0;
        double IMC;
        boolean ciclo = true;
        
        do{
            try{
                System.out.println("Ingrese talla del paciente (en metros)");
                System.out.print("Talla ingresada: ");
                talla = input.nextDouble();
                
                while(talla>2.5 || talla<0.7){
                    System.out.println("ERROR: Ingrese un valor válido");
                    System.out.print("Talla ingresada: ");
                    talla = input.nextDouble();
                }
                
                System.out.println("Ingrese peso del paciente (en kg)");
                System.out.print("Peso ingresado: ");
                peso = input.nextDouble();
                
                while(peso<0 || peso>300){
                    System.out.println("ERROR: Ingrese un valor válido");
                    System.out.print("Peso ingresado");
                    peso = input.nextDouble();
                }
                
                ciclo = false;
                
            }catch(InputMismatchException e){
                System.err.printf("\n ERROR: %s\n", e);
                input.nextLine();
                System.out.println("Sólo se aceptan valores numéricos");
            }
            
        }while(ciclo);
        
        IMC = peso/(Math.pow(talla, 2));
        return IMC;
    }
    
    public static void condicionPaciente(double x){
        System.out.print("Condición del Paciente: ");
        if(x<15){
            System.out.println("Desnutrición MUY severa");
        }else{
            if(x<16){
                System.out.println("Desnutrición severa grado 3");
            }else{
                if(x<17){
                    System.out.println("Desnutrición severa grado 2");
                }else{
                    if(x<18.5){
                        System.out.println("Desnutrición severa grado 1");
                    }else{
                        if(x<25){
                            System.out.println("Normal");
                        }else{
                            if(x<30){
                                System.out.println("Sobrepeso");
                            }else{
                                if(x<35){
                                    System.out.println("Obesidad grado 1");
                                }else{
                                    if(x<40){
                                        System.out.println("Obesidad grado 2");
                                    }else{
                                        System.out.println("Obesidad grado 3");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
}
