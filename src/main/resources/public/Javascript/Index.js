$('form').on('submit', e => 
{
    e.preventDefault()
    let data = { email: $('#inputemail').val(), senha: $('#inputsenha').val() }

    $.post ('http://localhost:5573/login', data, res => {
            let data = JSON.parse(res)
            if (data.LoginEfetuado) 
            {
                if (data.isAdm) {
                    window.location.href = `./Produtos.html`;  
                } else {
                    window.location.href = `./Site.html`;  
                }
            } 
            else  
            {
                $('.result').html(`<div class="bg-danger text-white rounded"> Email ou senha incorretos, tente novamente </div>`) 
            }
        }
    )
})


function verifyUrl() {
    const queryString = window.location.search;
    if (queryString) {
        const urlParams = new URLSearchParams(queryString);
        const auth = Boolean(urlParams.get('auth'))
        if (auth) {
            $('.result').html(`<span class="text-success">Cadastro efetuado com sucesso!</span>`)   
        }
    }
}

verifyUrl()
