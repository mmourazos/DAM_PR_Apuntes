let orden = function ordena(x, y) {
    return y - x;
}

let ordLamb = (x, y) => y - x;

let array = [6, 5, 3, 4, 5, 1, -1];

array.sort((x, y) => y - x)

console.log(array)