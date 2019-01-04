
/**
 * global vs local
 * var to declare local variables
 */

// la diferencia entre el anterior es que en este no se declara que la variable sea nueva, por lo que
//lo que hace es asignar a la variable global un valor. EN myscope, al no estar esta creada, crea la variable global con ese nombre
// y ese valor.
//

scope = "global";

function checkscope2() {
    
    scope = "local";
    myscope = "local";

    return [scope, myscope];
}

console.log(checkscope2());

console.log(scope);
console.log(myscope);           // => WTF ¿?
