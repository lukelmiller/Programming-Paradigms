# Author: Luke Miller
# Project: Assignment9
# Description: take in two txt files one removes words from the first. Then from the first determine the most frequently occurring word pairs.
# Date: 4.9.2020

import sys

def iny():

    print("Story file name: ");
    textFname = input();
    
    print("Skip word file name: ");
    ignoresFname = input();
    
    processor(textFname,ignoresFname);


def processor(textFname,ignoresFname):
    try:
        f1 = open(textFname, "r");
        text = f1.read();
        f1.close();
        f2 = open(ignoresFname, "r");
        ignores = f2.read();
        f2.close();
        spliter(text,ignores);
    except (OSError, IOError) as e:
        print("ERROR: " + str(e) + "\n exiting...");
        sys.exit(1);
        
        
def findMax(occurances):
    maxes = [0,0,0,0,0];
    indexes = [0,0,0,0,0];
    for i in range(len(occurances)-1):
        flag = False;
        for k in range(len(maxes)-1):
            if(occurances[i] > maxes[k] and flag == False):
                temp = maxes[k];
                tempIndex = indexes[k];
                maxes[k] = occurances[i];
                indexes[k] = i;
                flag = True;
                for j in range(len(maxes)-1):
                    if(temp > maxes[j]):
                        maxes.insert(j, temp);
                        indexes.insert(j, tempIndex);
                        maxes.pop();
                        indexes.pop();
                        break;
                
    return indexes;   


def finder(word, ignorez):
    for igWord in ignorez:
            if(word == igWord):
                return True;
    return False;


def printer(indexes, pairs, occurance):     
    print("The five most frequently occurring word pairs are:");
    for i in range(len(indexes)):
        print("('" + str(pairs[indexes[i]]) + "', " + str(occurance[indexes[i]]) +")");         
                
    
def spliter(text, ignores):
    
    ignoreWords = ignores.split(',');
    textLowered = text.lower();
    erasures = ['\n','\t','.','?','!',',',';',':','\'','\"']
    
    for car in erasures:
        if(car == '\n'):
            textLowered = textLowered.replace(car, " ");
        else:
            textLowered = textLowered.replace(car, "");
    
    wordsInList = textLowered.split(' ');
    
    while("" in wordsInList) : 
        wordsInList.remove(""); 
        
        
    for word in wordsInList:
        if(finder(word, ignoreWords)):
            wordsInList.remove(word);
    for word in wordsInList:
        if(finder(word, ignoreWords)):
            wordsInList.remove(word);   
           
    pairs = list();
    occurance = list();
    
    for i in range(len(wordsInList)-1):
        temp = "";
        flag = False;
        if(wordsInList[i+1]):
            temp = wordsInList[i] + " "+ wordsInList[i+1];
            if(len(pairs) == 0):
                pairs.append(temp);
                occurance.append(1);
                flag = True;
        
        for k in range(len(pairs)-1):
            if(temp == pairs[k] and flag != True):
                occurance[k] = occurance[k] + 1; 
                occurance.insert(0, occurance[k]);
                pairs.insert(0, pairs[k]);
                occurance[k+1]=0;
                pairs[k+1]=' ';
                flag = True;
                        
        if(flag != True):
            pairs.append(temp);
            occurance.append(1); 

    indexes = findMax(occurance); 

    print("Skip Words: " + str(ignoreWords));
    printer(indexes, pairs, occurance);
     

def main():
    iny();

    
if __name__ == "__main__":
    main()