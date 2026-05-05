const prompt = require('prompt-sync')();

function getWage(numberOfParcel, amountPerParcel) {
    const BASE_PAY = 5000;
    let wage = (numberOfParcel * amountPerParcel) + BASE_PAY;  
    return wage;
}

function print(message) { console.log(message); }

while (true) {
    const board = `
        ________________________________________________________________
        |   |                   |                   |                  |
        |SN |  Collection Rate  | Amount Per Parcel |      Base Pay    |
        |___|___________________|___________________|__________________|
        |   |                   |                   |                  |
        | 1 |   Less than 50%   |       160         |       5,000      |
        |___|___________________|___________________|__________________|
        |   |                   |                   |                  |
        | 2 |   50 - 59%        |       200         |       5,000      |
        |___|___________________|___________________|__________________|
        |   |                   |                   |                  |
        | 3 |   60 - 69%        |       250         |       5,000      |
        |___|___________________|___________________|__________________|
        |   |                   |                   |                  |
        | 4 |   >=70%           |       500         |       5,000      |
        |___|___________________|___________________|__________________|
    `;

    print(board);

    let successfulDelivery = Number(prompt("Enter number of Successful Delivery: "));

    let amountPerParcel = 0;


    if (successfulDelivery < 50) {
        amountPerParcel = 160;
    } else if (successfulDelivery <= 59) {   
        amountPerParcel = 200;
    } else if (successfulDelivery <= 69) {   
        amountPerParcel = 250;
    } else if (successfulDelivery >= 70 && successfulDelivery<101) {
        amountPerParcel = 500;
    } else {
        print("Invalid input");
    }

    if (amountPerParcel > 0) {
        print(`Your wage is: ${getWage(successfulDelivery, amountPerParcel)}`); 
    }

    let more = prompt("Will you like to place more orders? (yes/no): ");
    if (more === "no") break;
}
