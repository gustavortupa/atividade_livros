import axios, { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Link, useNavigate} from 'react-router-dom';
import { Livro } from 'types/livro';
import { BASE_URL } from 'utils/requests';
import { validateEmail } from 'utils/validate';
import './styles.css'

type Props = {
    livroId: string
}
function FormCard( {livroId}: Props){

    const [livro, setLivro] = useState<Livro>()

    const navigate = useNavigate()

    useEffect(() => {
        axios.get(`${BASE_URL}/livros/${livroId}`)
        .then( response => {
            setLivro(response.data)
        })
    }, [livroId])
    
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        const email = (event.target as any).email.value
        const score = (event.target as any).score.value
        if (!validateEmail(email)){
            return 
        }

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'PUT',
            url: '/scores',
            data: {
                email: email,
                livroId: livroId,
                score: score
            }
        }

        axios(config)
        .then(response => {
            navigate("/")
        })
    }
    return (
        <div className="livros-form-container">
            <img className="livros-livro-card-image" src={livro?.image} alt={livro?.title} />
            <div className="livros-card-bottom-container">
                <h3> {livro?.title}</h3>
                <form className="livros-form" onSubmit={handleSubmit}>
                    <div className="form-group livros-form-group">
                        <label htmlFor="email">Informe seu email:</label>
                        <input type="email" className="form-control" id="email" />
                    </div>
                    <div className="form-group livros-form-group">
                        <label htmlFor="score">Informe sua avaliação</label>
                        <select className="form-control" id="score">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div className="livros-form-btn-container">
                        <button type="submit" className="btn btn-primary livro-btn">Salvar</button>
                    </div>
                </form >
                <Link to="/">
                    <button className="btn btn-primary livro-btn mt-3">Cancelar</button>
                </Link>
                
            </div >
        </div >
    )
}


export default FormCard