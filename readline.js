const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
//var answer;
//rl.on('line', (input) => {
//    console.log(`Received: ${input}`);
////});
//rl.on('pause', () => {
//    console.log('Readline paused.');
//});
//rl.on('SIGCONT', () => {
//    // `prompt` will automatically resume the stream
//    rl.prompt();
//});
rl.on('SIGINT', () => {
    rl.question('Are you sure you want to exit? ', (answer) => {
        if (answer.match(/^y(es)?$/i)) rl.pause();
    });
});


//console.log(answer);
