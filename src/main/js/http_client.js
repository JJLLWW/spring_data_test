const WEB_HOSTNAME="localhost";
const WEB_PORT="8080";
const WEB_URL=`http://${WEB_HOSTNAME}:${WEB_PORT}`;

async function testGet() {
    const getRequest = new Request(`${WEB_URL}/board/1`, { method: "GET" });
    const response = await fetch(getRequest);
    const fen = await response.text();
    console.log(fen);
}

async function testSet() {
    const putRequest = new Request(
        `${WEB_URL}/board/1`,
        { 
            method: "PUT",
            body: "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2"
        });
    await fetch(putRequest);
}

async function main() {
    await testSet();
    testGet();
}

main();