import * as React from 'react';
import { Auth } from './App';

import ReactTable from "react-table";
import "./react-table.css";

interface TodoListDto {
  id: number;
  name: string;
  itemCount: number;
}

interface TodoListListProps {
	auth: Auth;
}

interface TodoListListState {
  todoLists: Array<TodoListDto>;
  isLoading: boolean;
  error: string;
}

class TodoListList extends React.Component<TodoListListProps, TodoListListState> {

  constructor(props: TodoListListProps) {
    super(props);

    this.state = {
	  todoLists: [],
	  isLoading: false,
	  error: ''
	};
  }

  async componentDidMount() {
    this.setState({isLoading: true});

	  try {
		const response = await fetch('http://localhost:8080/all-todoLists', {
		  headers: {
			Authorization: 'Bearer ' + await this.props.auth.getAccessToken()
		}
	  });
		const data = await response.json();
		this.setState({todoLists: data, isLoading: false});
	  } catch (err) {
		this.setState({error: err});
	  }
  }

  render() {
    const {todoLists, isLoading, error} = this.state;

	if (isLoading) {
		return <p>Loading ...</p>;
	}

	if (error.length > 0) {
		return <p>Error: {error}</p>;
	}

    return (
      <div>
        <ReactTable
          data={todoLists}
          columns={
            [
              {
                columns:
                  [
                    {
                      Header: "List Name",
                      accessor: "name"
                    }
                  ]
              },
              {
                columns:
                  [
                    {
                      Header: "Item Count",
                      accessor: "itemCount"
                    }
                  ]
              }
            ]}
          defaultPageSize={10}
          className="-striped -highlight"
          getTrProps={(state, rowInfo) => {
            return {
              onClick: (e) => {
                this.setState({
                  selected: rowInfo.index
                });
                window.open("http://localhost:8080/todoList/" + rowInfo.row.id, "_blank");
              },
              style: {
                background: rowInfo.index === this.state.selected ? '#00afec' : 'white',
                color: rowInfo.index === this.state.selected ? 'white' : 'black'
              }
            }
          }
          }
        />
      </div>
    );
  }
}

export default TodoListList;