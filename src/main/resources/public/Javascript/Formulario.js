$('form').submit(e => {
    e.preventDefault()
    
    let data = $('form').serialize()

    $.post('/formulario', data, res => {
        let response = JSON.parse(res)
        window.location.href = `./Resposta.html?id=${response.id}`
    })
})