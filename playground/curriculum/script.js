
function titleClick() {
    var titleButton = document.getElementById('title');
    
    // Introduce a slight delay before adding the "floating" class
    setTimeout(function() {
        titleButton.classList.add('floating');
    }, 10);

    // You can also remove the onclick attribute to prevent further clicks
    titleButton.removeAttribute('onclick');
}


function github() {
    var urlGitHub = 'https://github.com/apellido04';

    // Obrir una nova pestanya amb la URL de GitHub
    window.open(urlGitHub, '_blank');
}

