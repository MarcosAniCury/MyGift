$('form').submit(e =>{
    e.preventDefault()

    let data = $('form').serialize()

    $.post('http://localhost:5573/autoformulario', data, res => {
        let resp = JSON.parse(res)
        window.location.href = `./Resposta.html?id=${resp.id}`
    })
})