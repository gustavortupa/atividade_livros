import {ReactComponent as GithubIcon} from 'assets/img/github.svg'
import './styles.css'
function Navbar() {
    return (
        <header>
        <nav className="container">
            <div className="livros-nav-content">
                <h1>Livros</h1>
                <a href="https://github.com/devsuperior" target="_blank" rel="noreferrer">
                    <div className="livros-contact-container">
                        <GithubIcon />
                        <p className="livros-contact-link">/devsuperior</p>
                    </div>
                </a>
            </div>
        </nav>
    </header>
    )
}

export default Navbar