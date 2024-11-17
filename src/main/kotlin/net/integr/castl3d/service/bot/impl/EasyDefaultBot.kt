/*
 * Copyright © 2024 Integr
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.integr.castl3d.service.bot.impl

import net.integr.castl3d.service.bot.Bot
import net.integr.castl3d.service.game.ChessBoard
import net.integr.castl3d.service.game.management.Castl3dBot

@Castl3dBot
class EasyDefaultBot : Bot("easy_default", "Easy") {
    override fun move(board: ChessBoard) {
        val moves = board.getAllValidBotMoves()

        if (moves.isNotEmpty()) {
            for (move in moves) {
                if (move.isCapture) {
                    board.move(move)
                    return
                }
            }

            val move = moves.random()
            board.move(move)
        }
    }
}