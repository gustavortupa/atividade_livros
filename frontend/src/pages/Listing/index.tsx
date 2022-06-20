import axios from "axios";
import MovieCard from "components/LivroCard";

import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { LivroPage } from "types/livro";
import { BASE_URL } from "utils/requests";

function Listing(){

    const [pageNumber, setPageNumber] = useState(0)

    const [page, setPage] = useState<LivroPage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    })

    
    useEffect(() => {
        axios.get(`${BASE_URL}/livros?size=12&page=${pageNumber}&sort=id `)
        .then(response => {
            const livros = response.data as LivroPage
            setPage(livros)
        })
    }, [pageNumber])
  
    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber)
    }

    return (
        <>
            <Pagination page={page} onChange={handlePageChange}/>
            <div className="container">
                <div className="row">
                    
                    {page.content.map(livro => (

                        <div key={livro.id} className="col-sm-6 col-lg-4 col-xl-3">
                        <MovieCard livro={livro}/>
                    </div>
                    ))}
                    
                </div>
            </div>
            
            
        </>
    )
}

export default Listing