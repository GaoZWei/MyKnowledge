import {query, UpdateById,deleteById} from '../services/sort'
import {addKnowledge} from "../services/knowledge";

export default {
  namespace: 'sorts',
  state: {
    sortList: []
  },
  reducers: {
    querySortSuccess(state, {payload: {data}}) {
      state.sortList = data
      return {...state}
    },
  },
  effects: {
    * querySort(payload, {put, call}) {
      const result = yield call(query);
      console.log(result)
      if (result) {
        yield put({
          type: 'querySortSuccess',
          payload: result
        });
      }
    },
    * updateSort({payload}, {put, call}) {
      console.log(payload.values)
      yield call(UpdateById, payload.values);
      yield put({
        type: "querySort"
      })
    },
    *deleteSort({payload}, {put, call}) {
      console.log(payload)
      yield call(deleteById,payload);
      yield put({
        type: "querySort"
      })
    }
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/sort') {
          dispatch({
            type: 'querySort',
            //payload: {}
          });
        } else if (location.pathname === '/addknowledge') {
          dispatch({
            type: 'querySort',
            //payload: {}
          });
        }
      });
    },
  },
}
