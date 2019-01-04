
/**
 * global vs local
 * nested scopes
 */

//Aqui la variable scope esta definida al inicio. Las funciones lo unico que hacen es crear una variable scope privada,
    // ya que usan var delante.

var scope = "global scope";

function checkscope() {
    
    var scope = "local scope";
    
    function nested() {
        
        var scope = "nested scope";
        return scope;
    }

    return nested();
}

console.log(checkscope());              // => "nested scope"
console.log(scope);                     // => "global scope"
