const search = document.getElementById("search")
const matchList = document.getElementById("match-list")

const searchStates = async searchText => {
    const res = await fetch('resources/js/list.json')
    const states = await res.json()

    //console.log(states);
    let matches = states.filter(state => {
        const regex = new RegExp(`^${searchText}`, 'gi')
        return state.match(regex)
    })

    if(searchText.length === 0) {
        matches = [];
        matchList.innerHTML = '';
    }

    outputHtml(matches);
}

const outputHtml = matches => {
    if(matches.length > 0) {
        const html = matches.map(match => `
        <div class="card card-body mb-4 search-item">
            <h4 class="search-item">${match}</h4>
        </div>
        `)
         .join('')

        matchList.innerHTML = html;
    }
}
search.addEventListener("input", () => searchStates(search.value))

document.body.addEventListener( 'click', function ( event ) {
    if( event.target.classList.contains('search-item') ) {
        document.getElementById('search').value = event.target.innerText
    }
} );



