import LivroStars from "components/LivroStars";
import './styles.css'

type Props = {
    score: number,
    count: number
}

function LivroScore( {score, count}: Props){

    return (
        <div className="livros-score-container">
            <p className="livros-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
            <MovieStars score={score}/>
            <p className="livros-score-count">{count} avaliações</p>
        </div>
    )
}

export default LivroScore;