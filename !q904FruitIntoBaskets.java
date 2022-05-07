class Solution {
    public int totalFruit(int[] fruits) {
        int curFruit = 1;
        int bestFruit = 1;
        int fruitBasket2 = fruits[0];
        int fruitBasket2Num = 1;
        int fruitBasket1 = -1;
        int fruitBasket1Num = 0;
        
        for(int i = 1; i < fruits.length; i++){
            if(fruits[i] != fruitBasket1 && fruits[i] != fruitBasket2){
                if(fruits[i-1] == fruitBasket2){
                    fruitBasket1 = fruitBasket2;
                    fruitBasket1Num = 0;
                    for(int j = i; j > 0 && fruits[j-1] == fruitBasket1; j--){
                        fruitBasket1Num++;
                    }
                    fruitBasket2 = fruits[i];
                    fruitBasket2Num = 1;
                    curFruit = fruitBasket1Num + 1;
                }
                else if(fruits[i-1] == fruitBasket1){
                    fruitBasket2 = fruitBasket1;
                    fruitBasket2Num = 0;
                    for(int j = i;j > 0 && fruits[j-1] == fruitBasket2; j--){
                        fruitBasket2Num++;
                    }
                    fruitBasket1 = fruits[i];
                    fruitBasket1Num = 1;
                    curFruit = fruitBasket2Num + 1;
                }
            }
            else if(fruits[i] == fruitBasket1){
                fruitBasket1Num++;
                curFruit++;
            }
            else if(fruits[i] == fruitBasket2){
                fruitBasket2Num++;
                curFruit++;
            }
            bestFruit = curFruit > bestFruit ? curFruit : bestFruit;
        }
        
        return bestFruit;
    }
    
}