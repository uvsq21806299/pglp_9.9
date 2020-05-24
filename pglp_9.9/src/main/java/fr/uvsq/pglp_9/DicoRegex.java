/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author andri
 */
public class DicoRegex {
    
        private static final String regex = ".+=.+";
	private static final Pattern pattern = Pattern.compile(regex);
        
        /**
         * Format de creation d'un Cercle
         */
        private static final String cercleRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
			+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern cerclePattern = Pattern.compile(cercleRegex);

        /**
         * Format de creation d'un Rectangle et d'un Carre
         */
        private static final String rectangle_carreRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\,"
			+ "\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*\\)";
	private static final Pattern rectangle_carrePattern = Pattern.compile(rectangle_carreRegex);

        /**
         * Format de creation d'un Triangle
         */
        private static final String triangleRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern trianglePattern = Pattern.compile(triangleRegex);

        /**
         * Format de deplacement d'une figure
         */
        private static final String regexMove = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]+)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*,"
			+ "\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternMove = Pattern.compile(regexMove);

        /**
         * Format de deplacement d'un groupe
         */
	private static final String regexAffiche = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-])+\\s*\\)";
	private static final Pattern patternAffiche = Pattern.compile(regexAffiche);

        /**
         * Format d'affichage de figure
         */
	private static final String regexGroup = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*(([a-zA-Z0-9_-]*\\s*+),*)+\\)";
	private static final Pattern patternGroup = Pattern.compile(regexGroup);

        /**
         * 
         * Verifie si la saisie par l'utilisateur est le meme que 
         * @param saisie : entree par l'utilisateur
         * @return vrai ou faux
         */
        public static boolean isMatching(String saisie)
        {
            Matcher matcher = pattern.matcher(saisie);
            if(matcher.matches())
            {
                matcher = cerclePattern.matcher(saisie);
            }
            if(matcher.matches()){
                return true;
            } 
            else{
                matcher = rectangle_carrePattern.matcher(saisie);
                if(matcher.matches()){
                    return true;
                }
                else{
                    matcher = trianglePattern.matcher(saisie);
                    if(matcher.matches()){
                    return true;
                    }
                    else{
                        matcher = patternMove.matcher(saisie);
                        if(matcher.matches()){
                        return true;
                        }
                        else{
                            matcher = patternGroup.matcher(saisie);
                            if(matcher.matches()){
                            return true;
                            }
                            else {
                                matcher = patternAffiche.matcher(saisie);
                                if(matcher.matches()){
                                return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            
        }
        
        
        public static List<String> splitSaisie(String saisie)
        {
            List<String> list = new ArrayList<String>();
		saisie = saisie.replaceAll("\\s","");
		saisie = saisie.replaceAll("=","#");
		saisie = saisie.replaceAll("\\(","#");
		saisie = saisie.replaceAll("\\)","#");
		saisie = saisie.replaceAll(",","#");
                
                for (String val: saisie.split("#"))
		{
			if(!val.equals("")) 
			{
				list.add(val);
			}
		}
		return list;
        }
        
        public Command verifCommand(String saisie){
            Command command = DrawingTUI.interpreteur.mapCommand.get(saisie);
            return command;
        }
        
        public boolean getMoveCommand(List<String> valeur){
            if(valeur.get(0).toLowerCase().matches("move")){
                return true;
            }else
                return false;
        }
        
        public boolean getGroupCommand(List<String> valeur){
            if(valeur.get(1).toLowerCase().matches("groupes"))
                return true;
            else
                return false;
        }
        
        public boolean getAfficheCommand(List<String> valeur){
            if(valeur.get(0).toLowerCase(Locale.ROOT).matches("affiche"))
                return true;
            else
                return false;
        }
}
