import {ReactComponent as Arrow} from 'assets/img/arrow.svg'
import { LivroPage } from 'types/livro'
import './styles.css'

type Props = {
    page: LivroPage;
    onChange: Function;
}

function Pagination( {page, onChange}: Props){
    return (
        <div className="livros-pagination-container">
            <div className="livros-pagination-box">
                <button className="livros-pagination-button" disabled={page.first} 
                    onClick={() => onChange(page.number - 1)}>
                    <Arrow />
                </button>
                <p>{`${page.number+1} de ${page.totalPages}`}</p>
                <button className="livros-pagination-button" disabled={page.last} 
                    onClick={() => onChange(page.number + 1)}>
                    <Arrow className="livros-flip-horizontal" />
                </button>
            </div>
        </div>
    )
}

export default Pagination