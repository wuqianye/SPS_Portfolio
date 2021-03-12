async function showRandomString() {
    const responseFromServer = await fetch('/randomstring');
    const quotes = await responseFromServer.json();

    const quote = quotes[Math.floor(Math.random() * quotes.length)]

    const stringContainer = document.getElementById('randomStringContainer');
    stringContainer.innerText = quote;
}