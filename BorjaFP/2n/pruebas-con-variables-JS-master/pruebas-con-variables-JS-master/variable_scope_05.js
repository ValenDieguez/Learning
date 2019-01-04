
/**
 * global vs local
 * function scope and hoisting
 */
    //. Js se ejecuta linea por linea. Al ejecutarse f, solo se ejecuta  el contenido de la funcion, con lo cual, todas las variables externas
    //quedan inusadas, por eso sale undefined, luego ejecuta normal. Al final hace el ultimo console.log
    // y usa la variable global.

var scope = "global";

function f() {

    console.log(scope);             // WTF !!
    var scope = "local";
    console.log(scope);             // Prints "local"
}

f();

console.log(scope);                 // Prints "global"