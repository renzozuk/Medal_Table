const path = "http://localhost:8080/country";

function processData() {
    return fetch(`${path}/gold`)
    .then((response) => {
        if (!response.ok) {
            throw new Error("Resposta de rede não foi ok");
        }
        return response.json();
    });
}

export default processData;