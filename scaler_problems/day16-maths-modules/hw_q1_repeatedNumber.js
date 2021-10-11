const repeatedNumber = function(A){
        
    const N = A.length;
    
    let sum = 0;
    let squareSum = 0;
    let arrSum = 0;
    let arrSquareSum = 0;
    
    // for(let i=1; i<=N; i++) {
    //     sum = sum + i;
    //     squareSum = squareSum + i*i;
    // }
    
    for(let i=1; i<=N; i++) {
        
        sum = sum + i;
        squareSum = squareSum + i*i;
        
        const currentElement = A[i-1];
        arrSum = arrSum + currentElement;
        arrSquareSum = arrSquareSum + (currentElement*currentElement);
    }
    
    let duplicate;
    let missing;
    
    duplicate = Math.floor(( Math.floor((squareSum - arrSquareSum) / (sum - arrSum)) - sum + arrSum) / 2);
    missing = (sum - arrSum) + duplicate;
    
    return [duplicate, missing];
    
}

repeatedNumber([3,1,2,5,3]);