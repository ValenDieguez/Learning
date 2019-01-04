
/**
 * global vs local
 * function scope and hoisting
 */
// aqui la var i no se usa. La primera en ejecutarse es el valor de k, en cada una de las posiciones del for.
// al terminar k ha asolido el valor 10 (por eso no se printa en el primer console.log) y se printa en el segundo.
// finalmente J que no ha sufrido ningun cambio  se printa al final


function test(o) {
    
    var i = 0;
    
    if (typeof o == "object") {
        
        var j = 0;
    
        for(var k=0; k < 10; k++) {
            console.log(k);             // print numbers 0 through 9
        }
    
        console.log(k);                 // prints 10
    }
    
    console.log(j);                     // j is defined, but may not be initialized
}

o = {};
test(o);
