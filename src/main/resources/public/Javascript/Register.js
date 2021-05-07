$('form').submit(e => {
    e.preventDefault()
    
    let data = $('form').serialize()

    $.post('http://localhost:5573/cadastro', data, res => {
        let response = JSON.parse(res)
        if (response.CadastroEfetuado) {
            window.location.href = './index.html?auth=true'
        } else {
            $('#error_message').html(`<span class="text-danger mt-2">Informações inválidas</span>`)
        }
    })

})



