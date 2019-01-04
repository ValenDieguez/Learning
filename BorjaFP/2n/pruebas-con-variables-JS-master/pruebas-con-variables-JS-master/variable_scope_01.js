
/**
 * global vs local
 */
    // Js ejecuta los programas linea por linea, por lo que en este caso, la variable scope, cuando es creada, se le da el primer valor.
    // Al llamar la funcion, esta sobrescribe temporalmente el valor de la variable scope, lo que hace que muestre este valor


 var scope = "global";

function checkscope() {
    var scope = "local";
    return scope;
}

console.log(checkscope());
console.log(scope);

// => "local"
