public class MiniParkingLot{


    public int countParkingLot(int [][]lot){
    int lotCount=0;
        for(int row=0; row<lot.length; row++){
        
            for(int column=0; column<lot[row].length;column++){
            
                lotCount++;
            }
        }
        
        return lotCount;
    }
    
    public boolean checkIfLotIsFull(int [][]lot){
    int emptyLotCount=0;
    int filledCount=0;
    int length = countParkingLot(lot);
    
    
        for(int row=0; row<lot.length; row++){
        
            for(int column=0; column<lot[row].length;column++){
            
                if(lot[row][column]==0) emptyLotCount++;
                else filledCount++;
            }
        }
        
        if(length==emptyLotCount)return false;
        else if(length==filledCount) return true;
        return false;
       
    }
    
    
    public int [][] parkACarBySequence(int [][]lot, String command){
    int emptyLotCount=0;
    int length = countParkingLot(lot);
    
        if (command == null || !command.equalsIgnoreCase("assign")) {
        return lot; 
    }
        for(int row=0; row<lot.length; row++){
        
            for(int column=0; column<lot[row].length;column++){
            
                if(lot[row][column]==0 && command.equalsIgnoreCase("assign")){ 
                
                    lot[row][column]=1;
                    return lot;
                    
               }
            }
        }
        
         return  lot;
        
    }
    
    
    public int [][] parkCarByLotNumber(int [][]lot, int lotNumber,String command ){
    int emptyLotCount=0;
    int length = countParkingLot(lot);
    lotNumber=lotNumber-1;
    
            if (lotNumber<0 || lotNumber>length-1) {
                return lot; 
            }else if(lotNumber>=0 && lotNumber<=9 && command.equalsIgnoreCase("assign")){
            
                   lot[0][lotNumber]=1;
                   return lot;
                }else{
                
                        int row = lotNumber/10;
                        int col = lotNumber%10;
                        lot[row][col]=1;
                        
                        return lot;
                    }
                }
                
                
                
    public int [][] unparkCarByLotNumber(int [][]lot, int lotNumber,String command ){
    int emptyLotCount=0;
    int length = countParkingLot(lot);
    lotNumber=lotNumber-1;
    
            if (lotNumber<0 || lotNumber>length) {
                return lot; 
            }else if(lotNumber>=0 && lotNumber<=9 && command.equalsIgnoreCase("unassign")){
            
                   if (lot[0][lotNumber]==1){ 
                        lot[0][lotNumber]=0;
                        return lot;
                   }else return lot;    
                        
                }else{
                            int row = lotNumber/10;
                            int col= lotNumber%10;
                            
                        if (lot[row][col]==1){
                            lot[row][col]=0;
                            
                            return lot;
                            
                        }else return lot;
                    }
                }
            
}
