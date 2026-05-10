

const prompt = require('prompt-sync')();
const board = `

                ________________________________________________________________
                |   |                   |                   |                  |
                |SN |   Pizza Type      | Number of Slices  |      Price       |
                |___|___________________|___________________|__________________|
                |   |                   |                   |                  |
                | 1 |   Sapa Size       |       4           |       2,000      |
                |___|___________________|___________________|__________________|
                |   |                   |                   |                  |
                | 2 |   Sapa Size       |       6           |       2,400      |
                |___|___________________|___________________|__________________|
                |   |                   |                   |                  |
                | 3 |   Sapa Size       |       8           |       3,000      |
                |___|___________________|___________________|__________________|
                |   |                   |                   |                  |
                | 4 |   Sapa Size       |       12          |       4,200      |
                |___|___________________|___________________|__________________|
            

    `;
    let numberOfSlices = 0;
    let pricePerBox = 0;
    

    console.log(board);
while(true){
    let option = parseInt(prompt("Enter option (1-4):"));
    let numberOfGuest = Number(prompt("Please enter the number of Guests: "));
    
   

    switch(option){
        case 1:{   numberOfSlices = 4;
                    pricePerBox = 2000;
                    console.log("You ordered Sapa Size:");
                    handleOrder(numberOfGuest);
                    break;
        }

        case 2:{   numberOfSlices = 6;
                    pricePerBox = 2400;
                    console.log("You Small Money:");
                    handleOrder(numberOfGuest);
                     break;
        }

        case 3:{   numberOfSlices = 8;
                    pricePerBox = 3000;
                    console.log("You ordered Sapa Size:");
                    handleOrder(numberOfGuest);
                     break;
        }

        case 4:{   numberOfSlices = 12;
                    pricePerBox = 4200;
                    console.log("You ordered Sapa Size:");
                    handleOrder(numberOfGuest);
                    break;
        }

        default:{   console.log("Invalid option");
                    break;
        }
        
        
        }
        
        let moreOrder = prompt("Will you like to place another order(yes/no):");
            if(moreOrder=="no") break;
        }
       


        function getNumberOfBox(numberOfGuest){
            
            let box = numberOfGuest/numberOfSlices;
            if(Math.floor(box) != box){
                return Math.floor(box +1);
            }
                return box;
        }

        function getTotalPrice(numberOfGuest){
            let price = getNumberOfBox(numberOfGuest) * pricePerBox;
            return price;
        }

        function getRemainder(numberOfGuest){
            let remainder = numberOfSlices * getNumberOfBox(numberOfGuest)-numberOfGuest;
            return remainder;
        }
        
        function handleOrder(numberOfGuest){
            console.log("The number boxes to buy = " + getNumberOfBox(numberOfGuest));
            console.log("Total price =" + getTotalPrice(numberOfGuest));
            console.log("Left Over = " + getRemainder(numberOfGuest));

        
        }
        


