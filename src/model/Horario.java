package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Horario implements Serializable, Comparable {
    private char diaDaSemana;
    private char periodo;
    private char hora;
    private Horario(char dia, char periodo, char hora) {
        this.diaDaSemana = dia;
        this.periodo = periodo;
        this.hora = hora;
    }
    public static ArrayList<Horario> adicionarHorario(String horario){
        ArrayList<Character> dias = new ArrayList<>();
        ArrayList<Horario> retorno = new ArrayList<>();
        String regex = "^([2-6]{1,5}[MTN][1-6]{1,6})( [2-6]{1,5}[MTN][1-6]{1,6}$)?$";
        Pattern padrao = Pattern.compile(regex);
        Matcher matcher = padrao.matcher(horario.trim());
        char[] horarioEmChar;
        char per;
        int i = 0;

        if(matcher.matches()){
            for(int num = 1; num < 3 && matcher.group(num) != null;num++){
                horarioEmChar = matcher.group(num).trim().toCharArray();
                for (i = 0; Character.isDigit(horarioEmChar[i]); i++){
                    dias.add(horarioEmChar[i]);
                }

                per = horarioEmChar[i];
                try {
                    for (char dia: dias) {
                        for (i = dias.size()+1; i < horarioEmChar.length; i++) {
                            if ("56".indexOf(horarioEmChar[i]) != -1 && per == 'N'){
                                throw new IllegalArgumentException("O periodo da Noite não possui os horarios 5 e 6");
                            }
                            retorno.add(new Horario(dia, per, horarioEmChar[i]));
                        }
                    }
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return null;
                }
                dias.clear();
            }
            Collections.sort(retorno);
            return retorno;
        }
        throw new IllegalArgumentException("Essa entrada não é um Horário válido");
    }
    public static boolean estaEmConflito(ArrayList<Horario> h1, ArrayList<Horario> h2){
        try {
            for(Horario h: h2){
                if (h1.contains(h)){
                    return true;
                }
            }
            return false;
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Horario hor = obj instanceof Horario?(Horario) obj:null;
        if (hor == null){
            return super.equals(obj);
        }
        return (hor.hora == hora) && (hor.diaDaSemana == diaDaSemana) && (hor.periodo == periodo);
    }

    @Override
    public String toString() {
        return ""+diaDaSemana+periodo+hora;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(""+diaDaSemana+periodo+hora);
    }

    @Override
    public int compareTo(Object o) {
        Horario h = (Horario) o;
        if (this.equals(h)){
            return 0;
        }
        else {
            if(diaDaSemana == h.diaDaSemana){
                if (periodo == h.periodo){
                    return hora > h.hora?1:-1;
                }
                else {
                    if (periodo == 'M'){
                        return 1;
                    } else if (h.periodo == 'M') {
                        return -1;
                    } else if (periodo == 'T') {
                        return 1;
                    }
                    else return -1;
                }
            }
            else {
                return diaDaSemana > h.diaDaSemana?1:-1;
            }
        }
    }
}
