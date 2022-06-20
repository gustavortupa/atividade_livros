import LivroScore from "components/LivroScore";
import { Link } from "react-router-dom";
import { Livro } from "types/livro";

type Props = {
    livro: Livro
}

function LivroCard({livro}: Props){

    

    return (
        <div>
            <img className="livros-livro-card-image" src={livro.image} alt={livro.title} />
            <div className="livros-card-bottom-container">
                <h3>{livro.title}</h3>
                <MovieScore count={livro.count} score={livro.score}/>
                <Link to={`/form/${livro.id}`}>
                    <div className="btn btn-primary livros-btn">Avaliar</div>
                </Link>
        </div>
        </div>
    )
}

export default LivroCard;