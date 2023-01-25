function ordena(x, y) {
    return x - y;
}

let array = [6, 5, 3, 4, 5, 1, -1];

array.sort(ordena)

console.log(array)